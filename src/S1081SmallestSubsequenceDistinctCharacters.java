import java.util.ArrayList;
import java.util.List;

public class S1081SmallestSubsequenceDistinctCharacters {
    public String smallestSubsequence(String text) {
        List<Character> res = new ArrayList<>();
        int i = 0;
        while (i < text.length()) {
            char c = text.charAt(i);
            if (res.contains(c)) {
                i++;
                continue;
            }
            int left = i, right = text.lastIndexOf(c), p = left, m = left;
            while (p < right) {
                if (res.contains(text.charAt(p))) {
                    p++;
                    continue;
                }

                int l = p, r = text.lastIndexOf(text.charAt(p));
                if (text.charAt(m) > text.charAt(l)) {
                    m = l;
                }
                if (l == r) {
                    break;
                }
                right = Math.min(right, r);
                p++;
            }
            res.add(text.charAt(m));
            i = m+1;
        }
        StringBuilder r = new StringBuilder();
        for (char c : res) {
            r.append(c);
        }
        return r.toString();
    }
}
