import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S0301RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int cnt = 0, left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) {
                    cnt++;
                } else {
                    left--;
                }
            }
        }
        cnt += left;

        HashSet<String> res = remove(new StringBuilder(), s.toCharArray(), 0, cnt, 0);
        return new ArrayList<>(res);
    }

    private HashSet<String> remove(StringBuilder sb, char[] c, int start, int cnt, int lefts) {
        HashSet<String> res = new HashSet<>();

        if (start == c.length) {
            if (cnt == 0 && lefts == 0) {
                res.add(sb.toString());
            }
            return res;
        }

        // c[start] == '(' or ')'
        if (c[start] == '(') {
            if (cnt > 0) {
                StringBuilder remove = new StringBuilder(sb);
                res.addAll(remove(remove, c, start+1, cnt-1, lefts)); // remove
            }
            StringBuilder keep = new StringBuilder(sb);
            keep.append('(');
            res.addAll(remove(keep, c, start+1, cnt, lefts+1));
        } else if (c[start] == ')') {
            if (cnt > 0) {
                StringBuilder remove = new StringBuilder(sb);
                res.addAll(remove(remove, c, start+1, cnt-1, lefts));
            }
            if (lefts > 0) {
                StringBuilder keep = new StringBuilder(sb);
                keep.append(')');
                res.addAll(remove(keep, c, start+1, cnt, lefts-1));
            }
        } else {
            StringBuilder keep = new StringBuilder(sb);
            keep.append(c[start]);
            res.addAll(remove(keep, c, start+1, cnt, lefts));
        }
        return res;
    }
}
