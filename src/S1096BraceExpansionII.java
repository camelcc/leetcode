import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class S1096BraceExpansionII {
    public List<String> braceExpansionII(String expression) {
        if (expression.isEmpty()) {
            return new ArrayList<>();
        }
        HashSet<String> res = new HashSet<>();
        HashSet<String> current = new HashSet<>();
        int p = 0;
        while (p < expression.length()) {
            char c = expression.charAt(p);
            if (c == '{') {
                int left = 1;
                int i = p+1;
                while (left != 0) {
                    if (expression.charAt(i) == '{') {
                        left++;
                    } else if (expression.charAt(i) == '}') {
                        left--;
                    }
                    i++;
                }
                List<String> braces = braceExpansionII(expression.substring(p+1, i-1));
                if (current.isEmpty()) {
                    current.addAll(braces);
                } else {
                    HashSet<String> next = new HashSet<>();
                    for (String cur : current) {
                        for (String brace : braces) {
                            next.add(cur + brace);
                        }
                    }
                    current = next;
                }
                p = i-1;
            } else if (c == ',') {
                res.addAll(current);
                current = new HashSet<>();
            } else {
                assert c != '}';
                HashSet<String> next = new HashSet<>();
                if (current.isEmpty()) {
                    next.add(String.valueOf(c));
                } else {
                    for (String cur : current) {
                        next.add(cur + c);
                    }
                }
                current = next;
            }
            p++;
        }
        res.addAll(current);
        List<String> r = new ArrayList<>(res);
        Collections.sort(r);
        return r;
    }
}
