public class S0474OnesZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int[] cnt = cnt(str);
            for (int i = m; i >= cnt[0]; i--) {
                for (int j = n; j >= cnt[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-cnt[0]][j-cnt[1]]+1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] cnt(String s) {
        int m = 0, n = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                m++;
            } else if (c == '1') {
                n++;
            }
        }
        return new int[]{m, n};
    }
}
