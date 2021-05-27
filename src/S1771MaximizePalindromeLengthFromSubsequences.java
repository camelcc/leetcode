public class S1771MaximizePalindromeLengthFromSubsequences {
    public int longestPalindrome(String word1, String word2) {
        int len = word1.length()+word2.length();
        Integer[][] dp = new Integer[len][len];
        int res = 0;
        for (int l = 0; l < word1.length(); l++) {
            char cl = word1.charAt(l);
            for (int r = word2.length()-1; r >= 0; r--) {
                char cr = word2.charAt(r);
                if (cl != cr) {
                    continue;
                }
                // cl == cr
                res = Math.max(res, 2+longest(word1, word2, l+1, word1.length()+r-1, dp));
            }
        }
        return res;
    }

    private int longest(String word1, String word2, int l, int r, Integer[][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != null) {
            return dp[l][r];
        }
        if (l == r) {
            return 1;
        }
        char cl = l < word1.length() ? word1.charAt(l) : word2.charAt(l-word1.length());
        char cr = r < word1.length() ? word1.charAt(r) : word2.charAt(r-word1.length());
        if (l+1 == r) {
            dp[l][r] = cl == cr ? 2 : 1;
            return dp[l][r];
        }
        if (cl == cr) {
            dp[l][r] = 2 + longest(word1, word2, l+1, r-1, dp);
            return dp[l][r];
        }
        int res = Math.max(longest(word1, word2, l+1, r, dp), longest(word1, word2, l, r-1, dp));
        dp[l][r] = res;
        return res;
    }
}
