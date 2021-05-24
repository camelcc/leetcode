public class S1745PalindromePartitioningIV {
    public boolean checkPartitioning(String s) {
        int N = s.length();
        char[] c = s.toCharArray();
        Boolean[][] dp = new Boolean[N][N];
        for (int i = 0; i < N-2; i++) {
            for (int j = i+1; j < N-1; j++) {
                if (valid(c, 0, i, dp) && valid(c, i+1, j, dp) && valid(c, j+1, c.length-1, dp)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean valid(char[] c, int i, int j, Boolean[][] dp) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (i == j) {
            return true;
        }
        if (c[i] != c[j]) {
            dp[i][j] = false;
            return false;
        }
        if (i+1 == j) {
            dp[i][j] = true;
            return true;
        }
        dp[i][j] = valid(c, i+1, j-1, dp);
        return dp[i][j];
    }
}
