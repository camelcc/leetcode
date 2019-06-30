import java.util.Arrays;
import java.util.Stack;

public class S0936StampingTheSequence {
    public int[] movesToStamp(String stamp, String target) {
        Stack<Integer> stamps = new Stack<>();
        char[] tar = new char[target.length()];
        Arrays.fill(tar, '*');
        String end = new String(tar);
        char[] current = target.toCharArray();
        char[] s = stamp.toCharArray();
        while (!end.equals(new String(current))) {
            int i = 0;
            while (i < current.length && !match(current, i, s)) {
                i++;
            }
            if (i == current.length) {
                return new int[0];
            }

            stamps.push(i);
            int t = 0;
            while (t < s.length) {
                current[i+t] = '*';
                t++;
            }
        }

        int[] res = new int[stamps.size()];
        int i = 0;
        while (!stamps.isEmpty()) {
            res[i++] = stamps.pop();
        }
        return res;
    }

    private boolean match(char[] current, int i, char[] stamp) {
        if (current.length - i < stamp.length) {
            return false;
        }
        boolean valid = false;
        int len = 0;
        while (len < stamp.length) {
            if (current[i+len] == '*') {
                len++;
                continue;
            }

            if (current[i+len] != stamp[len]) {
                return false;
            }

            valid = true;
            len++;
        }
        return valid;
    }
}
