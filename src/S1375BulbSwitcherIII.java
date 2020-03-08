import java.util.HashSet;

public class S1375BulbSwitcherIII {
    public int numTimesAllBlue(int[] light) {
        HashSet<Integer> on = new HashSet<>();
        boolean[] blue = new boolean[light.length+1];
        blue[0] = true;

        int res = 0;
        for (int i = 0; i < light.length; i++) {
            int l = light[i];
            if (blue[l-1]) {
                blue[l] = true;
                int n = l+1;
                while (n <= light.length && on.contains(n)) {
                    on.remove(n);
                    blue[n] = true;
                    n++;
                }
                if (on.isEmpty()) {
                    res++;
                }
            } else {
                on.add(l);
            }
        }
        return res;
    }
}
