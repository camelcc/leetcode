public class S0115DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        } else if (s.length() == t.length()) {
            return s.equals(t) ? 1 : 0;
        }
        if (t.isEmpty()) {
            return 1;
        }

        // s.len > t.len > 0
        int[][] dp = new int[t.length()][s.length()];
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != t.charAt(i)) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int sum = 0;
                for (int k = 0; k < j; k++) {
                    sum += dp[i-1][k];
                }
                dp[i][j] = sum;
            }
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += dp[t.length()-1][i];
        }
        return res;
    }
}
