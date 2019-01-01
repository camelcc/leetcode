public class S0583DeleteOperationTwoStrings {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        int common = dp[word1.length()][word2.length()];
        return word1.length() + word2.length() - common - common;
    }
}
