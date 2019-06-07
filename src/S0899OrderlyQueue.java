import java.util.Arrays;

public class S0899OrderlyQueue {
    public String orderlyQueue(String S, int K) {
        if (K > 1) {
            char[] c = S.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }
        String res = S;
        for (int i = 1; i < S.length(); i++) {
            String t = S.substring(i)+S.substring(0, i);
            if (res.compareTo(t) > 0) {
                res = t;
            }
        }
        return res;
    }
}
