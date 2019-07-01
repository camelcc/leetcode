import java.util.Arrays;

public class S0940DistinctSubsequencesII {
    public int distinctSubseqII(String S) {
        int n = S.length(), M = (int)1e9 + 7;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] count = new int[26];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int index = S.charAt(i) - 'a';
            dp[i] += sum - count[index];
            dp[i] = (dp[i] + M) % M;
            sum = (sum + dp[i]) % M;
            count[index] = (count[index] + dp[i]) % M;
        }
        return sum;
    }
}
