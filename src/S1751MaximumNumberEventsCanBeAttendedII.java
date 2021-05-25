import java.util.*;

public class S1751MaximumNumberEventsCanBeAttendedII {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < events.length; i++) {
            int s = events[i][0];
            if (map.containsKey(s)) {
                continue;
            }
            map.put(s, i);
        }

        int[][] dp = new int[events.length][k+1];
        return max(events, map, 0, k, dp);
    }

    private int max(int[][] events, TreeMap<Integer, Integer> map, int p, int k, int[][] dp) {
        if (p >= events.length) {
            return 0;
        }
        if (dp[p][k] != 0) {
            return dp[p][k];
        }
        int res = 0;
        if (k == 1) {
            for (int i = p; i < events.length; i++) {
                res = Math.max(res, events[i][2]);
            }
            dp[p][k] = res;
            return res;
        }
        // k > 1
        // not choose
        res = max(events, map, p+1, k, dp);
        // choose
        int r = events[p][2];
        Integer n = map.higherKey(events[p][1]);
        if (n != null) {
            r = r + max(events, map, map.get(n), k-1, dp);
        }
        res = Math.max(res, r);
        dp[p][k] = res;
        return res;
    }
}
