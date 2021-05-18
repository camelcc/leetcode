import java.util.HashMap;
import java.util.Stack;

public class S1717MaximumScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'b') {
                sb.append(c);
            } else {
                if (sb.length() >= 2) {
                    res += score(sb.toString(), x, y);
                }
                sb = new StringBuilder();
            }
        }
        if (sb.length() >= 2) {
            res += score(sb.toString(), x, y);
        }
        return res;
    }

    private int score(String s, int x, int y) {
        int res = 0;
        StringBuilder sb = new StringBuilder();
        if (x > y) {
            res += removeAB(s, x, sb);
            res += removeBA(sb.toString(), y, new StringBuilder());
        } else {
            res += removeBA(s, y, sb);
            res += removeAB(sb.toString(), x, new StringBuilder());
        }
        return res;
    }

    private int removeAB(String s, int x, StringBuilder sb) {
        int res = 0;
        char[] stack = new char[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                stack[i++] = c;
            } else { // c == 'b'
                if (i > 0 && stack[i-1] == 'a') {
                    res += x;
                    i--;
                } else {
                    stack[i++] = c;
                }
            }
        }
        for (int t = 0; t < i; t++) {
            sb.append(stack[t]);
        }
        return res;
    }

    private int removeBA(String s, int y, StringBuilder sb) {
        int res = 0;
        char[] stack = new char[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                if (i > 0 && stack[i-1] == 'b') {
                    res += y;
                    i--;
                } else {
                    stack[i++] = c;
                }
            } else { // c == 'b'
                stack[i++] = c;
            }
        }
        for (int t = 0; t < i; t++) {
            sb.append(stack[t]);
        }
        return res;
    }
}
