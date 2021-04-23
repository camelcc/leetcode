import java.util.HashMap;

public class S1655DistributeRepeatingIntegers {
    public boolean canDistribute(int[] nums, int[] quantity) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int[] cnt = new int[map.size()];
        int i = 0;
        for (int t : map.values()) {
            cnt[i++] = t;
        }
        Boolean[][] dp = new Boolean[cnt.length][0x1<<quantity.length];
        return can(cnt, quantity, 0, 0, dp);
    }

    private boolean can(int[] cnt, int[] quantity, int c, int p, Boolean[][] dp) {
        int UP = 0x1<<quantity.length;
        if (p >= UP-1) {
            return true;
        }
        if (c >= cnt.length) {
            return false;
        }
        // p < UP, c < cnt.len
        if (dp[c][p] != null) {
            return dp[c][p];
        }
        boolean res = can(cnt, quantity, c+1, p, dp);
        if (res) {
            dp[c][p] = true;
            return true;
        }
        for (int i = p+1; i < UP; i++) {
            int q = cnt(quantity, p, i);
            if (q == -1 || q > cnt[c]) {
                continue;
            }

            cnt[c] -= q;
            boolean r = can(cnt, quantity, c+1, i, dp);
            cnt[c] += q;
            if (r) {
                dp[c][p] = true;
                return true;
            }
        }
        dp[c][p] = false;
        return false;
    }

    private int cnt(int[] quantity, int q, int i) {
        if ((q|i) != i || q == i) {
            return -1;
        }
        // i includes q
        int res = 0;
        int diff = q^i;
        for (int j = 0; j < quantity.length; j++) {
            if ((diff & (0x1<<j)) != 0) {
                res += quantity[j];
            }
        }
        return res;
    }
}
