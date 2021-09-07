public class S1994TheNumberGoodSubsets {
    public int numberOfGoodSubsets(int[] nums) {
        int MOD = 1_000_000_007;
        long[] dp = new long[1+(0x1<<10)];
        int[] bits = new int[]{0,
                // 1-10
                0, 0x1, 0x2, 0, 0x4, 0x3, 0x8, 0, 0, 0x5,
                // 11-20
                0x10, 0, 0x20, 0x9, 0x6, 0, 0x40, 0, 0x80, 0,
                // 21-30
                0xA, 0x11, 0x100, 0, 0, 0x21, 0, 0, 0x200, 0x7};
        int[] cnt = new int[31];
        for (int n : nums) {
            cnt[n]++;
        }
        for (int i = 0; i < 31; i++) {
            if (bits[i] == 0 || cnt[i] == 0) {
                continue;
            }
            int v = bits[i];
            for (int j = 0; j < (0x1<<10); j++) {
                if ((v&j) != 0) {
                    continue;
                }
                int t = j|v;
                dp[t] = (dp[t]+dp[j]*cnt[i])%MOD;
            }
            dp[v] += cnt[i];
        }
        long res = 0;
        for (long d : dp) {
            res = (res+d)%MOD;
        }
        while (cnt[1] > 0) {
            res = (res<<1)%MOD;
            cnt[1]--;
        }
        return (int)res;
    }
}
