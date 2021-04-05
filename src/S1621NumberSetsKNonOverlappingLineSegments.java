public class S1621NumberSetsKNonOverlappingLineSegments {
    public int numberOfSets(int n, int k) {
        Integer[][] dp = new Integer[n+1][k+1];
        return dp(n, k, dp);
    }

    private int dp(int n, int k, Integer[][] dp) {
        if (dp[n][k] != null) {
            return dp[n][k];
        }
        if (k >= n) {
            return 0;
        }
        if (k == n - 1) {
            return 1;
        }
        if (k == 1) {
            return n * (n - 1) / 2;
        }
        int MOD = 1_000_000_007;
        long res = dp(n-1, k, dp);
        for (int i = 1; i < n; i++) {
            res += dp(n - i, k - 1, dp);
        }
        res = res % MOD;
        dp[n][k] = (int) res;
        return (int) res;
    }
}
