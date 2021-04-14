import java.util.HashMap;

public class S1643KthSmallestInstructions {
    public String kthSmallestPath(int[] destination, int k) {
        int h = destination[1], v = destination[0];
        HashMap<String, Integer> dp = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while (h != 0 || v != 0) {
            if (h == 0) {
                sb.append('V');
                v--;
            } else if (v == 0) {
                sb.append('H');
                h--;
            } else {
                int c = cnt(h-1, v, dp);
                if (c >= k) {
                    sb.append('H');
                    h--;
                } else {
                    sb.append('V');
                    v--;
                    k -= c;
                }
            }
        }
        return sb.toString();
    }

    private int cnt(int h, int v, HashMap<String, Integer> dp) {
        String k = h+","+v;
        if (dp.containsKey(k)) {
            return dp.get(k);
        }
        int res = 0;
        if (h == 0 && v == 0) {
            dp.put(k, 0);
            return 0;
        }
        if (h == 0 || v == 0) {
            dp.put(k, 1);
            return 1;
        }
        res = cnt(h-1, v, dp) + cnt(h, v-1, dp);
        dp.put(k, res);
        return res;
    }
}
