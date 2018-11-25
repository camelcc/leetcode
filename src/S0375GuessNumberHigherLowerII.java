public class S0375GuessNumberHigherLowerII {
    private int[][] dp = new int[0][0];

    public int getMoneyAmount(int n) {
        int res = 0;
        dp = new int[n+1][n+1];
        return dp(dp, 1, n);
    }

    private int dp(int[][] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int guess = start; guess <= end; guess++) {
            int g = guess + Math.max(dp(dp, start, guess-1), dp(dp, guess+1, end));
            res = Math.min(res, g);
        }
        dp[start][end] = res;
        return res;
    }
}
