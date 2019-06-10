public class S0096UniqueBST {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int len = 2; len <= n; len++) {
            int res = 0;
            for (int left = 0; left < len; left++) {
                res += dp[left]*dp[len-left-1];
            }
            dp[len] = res;
        }
        return dp[n];
    }
}
