public class S0416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;

        boolean[][] dp = new boolean[nums.length+1][sum+1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < nums[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] | dp[i-1][j - nums[i-1]];
                }
            }
        }

        return dp[nums.length][sum];
    }
}
