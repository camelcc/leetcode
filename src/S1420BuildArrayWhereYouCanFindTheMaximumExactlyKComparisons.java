import java.util.Arrays;

public class S1420BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {
    public int numOfArrays(int n, int m, int k) {
        if (k == 0) {
            return 0;
        }

        int[][][] dp = new int[n+1][m+1][k+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                Arrays.fill(dp[i][j], -1);
                dp[i][j][0] = 0;
            }
        }
        for (int i = 0; i < m+1; i++) {
            Arrays.fill(dp[0][i], 0);
        }
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(dp[i][0], 0);
        }
        for (int i = 1; i < n+1; i++) {
            Arrays.fill(dp[i][1], 0);
            dp[i][1][1] = 1;
        }
        for (int i = 1; i < m+1; i++) {
            Arrays.fill(dp[1][i], 0);
            dp[1][i][1] = i;
        }

        return dp(n, m, k, dp);
    }

    private int dp(int n, int m, int k, int[][][] dp) {
        if (dp[n][m][k] != -1) {
            return dp[n][m][k];
        }
        int MOD = (int)Math.pow(10, 9)+7;
        int res = 0;

        if (k == 1) {
            // A[m][n-1]
            long cnt = 1;
            for (int i = 0; i < n-1; i++) {
                cnt *= m;
                cnt = cnt%MOD;
            }

            cnt += dp(n, m-1, k, dp);
            cnt = cnt%MOD;
            res = (int)cnt;
            dp[n][m][k] = res;
            return res;
        }

        // n != 0|1, m != 0|1, k != 0|1
        // not contains m
        long cnt = dp(n, m-1, k, dp);
        // contains m
        for (int i = 0; i < n; i++) {
            long t = dp(i, m-1, k-1, dp);
            if (t == 0) {
                continue;
            }
            for (int j = i+1; j < n; j++) {
                t *= m;
                t = t%MOD;
            }
            cnt += t;
            cnt = cnt%MOD;
        }
        res = (int)cnt;
        dp[n][m][k] = res;
        return res;
    }
}
