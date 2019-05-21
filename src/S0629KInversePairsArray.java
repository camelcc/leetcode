import java.util.Arrays;

public class S0629KInversePairsArray {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        Arrays.fill(dp[0], 0);
        return inverse(n, k, dp);
    }

    private int inverse(int n, int k, int[][] dp) {
        if (k < 0) {
            return 0;
        }
        if (dp[n][k] != -1) {
            return dp[n][k];
        }

        if (k == 0) {
            dp[n][k] = 1;
            return 1;
        }
        if (n == 1) {
            dp[n][k] = 0;
            return 0;
        }

        // n >= 2, k >= 1
        int MOD = (int)Math.pow(10, 9) + 7;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            if (n-i > k) {
                continue;
            }

            res += inverse(n-1, k-(n-i), dp);
        }
        res = res % MOD;
        dp[n][k] = (int)res;
        return (int)res;
    }
}
