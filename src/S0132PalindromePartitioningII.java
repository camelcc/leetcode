public class S0132PalindromePartitioningII {
    public int minCut(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int[] cut = new int[s.length()];
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            int c = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) != s.charAt(i)) {
                    continue;
                }
                if (j+1 == i || j == i) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i-1][j+1];
                }

                if (dp[i][j]) {
                    c = j == 0 ? 0 : Math.min(c, cut[j-1] + 1);
                }
            }
            cut[i] = c;
        }
        return cut[s.length()-1];
    }
}
