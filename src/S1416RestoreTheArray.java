import java.util.Arrays;

public class S1416RestoreTheArray {
    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dp(s, k, 0, dp);
    }

    private int dp(String s, int k, int index, int[] dp) {
        if (dp[index] != -1) {
            return dp[index];
        }
        if (s.charAt(index) == '0') {
            dp[index] = 0;
            return 0;
        }
        if (index == s.length()-1) {
            dp[index] = s.charAt(index)-'0' > k ? 0 : 1;
            return dp[index];
        }

        long res = 0;
        int MOD = (int)(Math.pow(10, 9)+7);
        int end = index+1;
        while (end <= s.length() && Long.parseLong(s, index, end, 10) <= k) {
            if (end == s.length()) {
                res++;
            } else {
                res += dp(s, k, end, dp);
            }
            res = res%MOD;
            end++;
        }

        dp[index] = (int)res;
        return dp[index];
    }
}
