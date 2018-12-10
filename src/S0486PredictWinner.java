public class S0486PredictWinner {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int[][] dp = new int[nums.length][nums.length];
        int s = dp(nums, dp, 0, nums.length-1);
        return s >= sum-s;
    }

    private int dp(int[] nums, int[][] dp, int i, int j) {
        assert i <= j;

        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i == j) {
            dp[i][j] = nums[i];
            return nums[i];
        }
        if (i +1 == j) {
            dp[i][j] = Math.max(nums[i], nums[j]);
            return dp[i][j];
        }
        dp[i][j] = Math.max(Math.min(dp(nums, dp, i+2, j), dp(nums, dp, i+1, j-1))+nums[i],
                Math.min(dp(nums, dp , i+1, j-1), dp(nums, dp, i, j-2))+nums[j]);
        return dp[i][j];
    }
}
