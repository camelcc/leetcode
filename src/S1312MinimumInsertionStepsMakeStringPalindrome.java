import java.util.Arrays;

public class S1312MinimumInsertionStepsMakeStringPalindrome {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return min(s, 0, s.length()-1, dp);
    }

    private int min(String s, int lo, int hi, int[][] dp) {
        if (lo >= hi) {
            return 0;
        }

        if (dp[lo][hi] != -1) {
            return dp[lo][hi];
        }

        if (s.length() <= 1) {
            dp[lo][hi] = 0;
            return 0;
        }

        if (s.charAt(lo) == s.charAt(hi)) {
            dp[lo][hi] = min(s, lo+1, hi-1, dp);
            return dp[lo][hi];
        }

        // lo != hi
        int left = 1 + min(s, lo, hi-1, dp);
        int right = 1 + min(s, lo+1, hi, dp);
        int res = Math.min(left, right);
        dp[lo][hi] = res;
        return res;
    }
}
