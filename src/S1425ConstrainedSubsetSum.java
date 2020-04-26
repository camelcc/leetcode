public class S1425ConstrainedSubsetSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        int res = nums[0];
        Integer[][] dp = new Integer[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = 1; j <= k && i-j >= 0; j++) {
                sum = Math.max(sum, dp[i-j][0]+nums[i]);
                if (sum > dp[i-j][1]+nums[i]) {
                    break;
                }
            }
            dp[i][0] = sum;
            dp[i][1] = Math.max(dp[i-1][1], sum);
            res = Math.max(res, sum);
        }
        return res;
    }
}
