import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S0010RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty() && s.isEmpty()) {
            return true;
        } else if (p.isEmpty()) {
            return false;
        }

        List<Integer>[] edges = new List[p.length() + 2];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
            edges[i].add(i+1);
        }
        char[] match = new char[p.length() + 2];
        match[0] = '\0';
        match[match.length-1] = '\0';
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            match[i + 1] = c;
            if (c == '*') {
                edges[i].remove((Integer) (i + 1));
                edges[i].add(i);
                edges[i].add(i + 2);
                int prev = i;
                while (prev >= 0) {
                    prev -= 2;
                    if (prev >= 0) {
                        if (p.charAt(prev) == '*') {
                            edges[prev].add(i+2);
                        } else {
                            edges[prev+1].add(i+2);
                            break;
                        }
                    } else {
                        edges[prev+1].add(i+2);
                    }
                }
            }
        }


        HashSet<Integer> current = new HashSet<>(edges[0]);
        int i = 0;
        while (i < s.length()) {
            if (current.isEmpty()) {
                break;
            }

            char sc = s.charAt(i);
            HashSet<Integer> next = new HashSet<>();
            for (int c : current) {
                if (c == match.length-1) {
                    continue;
                }

                char dc = match[c];
                if (dc == '.' || dc == sc) {
                    next.addAll(edges[c]);
                }
            }
            i++;
            current = next;
        }
        return current.contains(match.length-1);
    }
}
