public class S0664StrangePrinter {
    public int strangePrinter(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int N = s.length();
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }
        for (int len = 1; len < N; len++) {
            for (int start = 0; start + len < N; start++) {
                dp[start][start+len] = len+1;
                for (int divide = 0; divide < len; divide++) {
                    int t = dp[start][start+divide] + dp[start+divide+1][start+len];
                    if (s.charAt(start) == s.charAt(start+len)) {
                        t--;
                    }
                    dp[start][start+len] = Math.min(dp[start][start+len], t);
                }
            }
        }

        return dp[0][N-1];
    }
}
