// https://leetcode.com/problems/count-number-of-special-subsequences/discuss/1382080/Java-15ms-O(N)-dp-with-comments
public class S1955CountNumberSpecialSubsequences {
    public int countSpecialSubsequences(int[] nums) {
        int mod = 1000000007;
        int[] dp = new int[]{1,0,0,0};

        for(int n : nums)
            dp[n+1] = (dp[n] + 2*dp[n+1]%mod)%mod;

        return dp[3];
    }
}
