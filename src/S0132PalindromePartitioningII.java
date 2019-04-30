import java.util.Arrays;

public class S0132PalindromePartitioningII {
    public int minCut(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) != s.charAt(i)) {
                    continue;
                }
                if (j+1 == i) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i-1][j+1];
                }
            }
        }
        int[] res = new int[s.length()];
        res[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int len = res[i-1]+1;
            for (int j = 0; j < i; j++) {
                if (dp[i][j]) {
                    len = Math.min(len, 1 + (j == 0 ? 0 : res[j-1]));
                }
            }
            res[i] = len;
        }
        return res[s.length()-1]-1;
    }
}
