import java.util.Arrays;
import java.util.HashSet;

public class S0672BulbSwitcherII {

    public int flipLights(int n, int m) {
        if (n == 0) {
            return 0;
        }
        if (m == 0) {
            return 1;
        }
        // n > 0, m > 0
        char[] init = new char[n];
        Arrays.fill(init, '1');
        HashSet<String> status = new HashSet<>();
        status.add(new String(init));

        for (int times = 0; times < m; times++) {
            HashSet<String> t = new HashSet<>();
            for (String s : status) {
                char[] bulbs = s.toCharArray();
                // steps > 0
                char[] b1 = Arrays.copyOf(bulbs, bulbs.length);
                char[] b2 = Arrays.copyOf(bulbs, bulbs.length);
                char[] b3 = Arrays.copyOf(bulbs, bulbs.length);
                char[] b4 = Arrays.copyOf(bulbs, bulbs.length);
                for (int i = 0; i < b1.length; i++) {
                    b1[i] = (b1[i] == '0' ? '1' : '0');
                    if ((i+1)%2 == 0) { // even
                        b2[i] = (b2[i] == '0' ? '1' : '0');
                    } else { // odd
                        b3[i] = (b3[i] == '0' ? '1' : '0');
                    }
                    if (i%3 == 0) {
                        b4[i] = (b4[i] == '0' ? '1' : '0');
                    }
                }
                t.add(new String(b1));
                t.add(new String(b2));
                t.add(new String(b3));
                t.add(new String(b4));
            }
            status = t;
        }

        return status.size();
    }
}
