public class S1143LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i1 = 0; i1 < text1.length(); i1++) {
            for (int i2 = 0; i2 < text2.length(); i2++) {
                if (text1.charAt(i1) == text2.charAt(i2)) {
                    dp[i1+1][i2+1] = dp[i1][i2]+1;
                } else {
                    dp[i1+1][i2+1] = Math.max(dp[i1][i2+1], dp[i1+1][i2]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
