public class S0312BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] d = new int[nums.length+2];
        d[0] = 1;
        int len = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            d[len++] = nums[i];
        }
        d[len++] = 1;
        int[][] dp = new int[len][len];
        return max(d, 0, len-1, dp);
    }

    private int max(int[] nums, int start, int end, int[][] dp) {
        if (start+1 == end) {
            return 0;
        }
        if (dp[start][end] > 0) {
            return dp[start][end];
        }
        int res = 0;
        for (int i = start+1; i < end; i++) {
            res = Math.max(res, nums[start]*nums[i]*nums[end]+max(nums, start, i, dp)+max(nums, i, end, dp));
        }

        dp[start][end] = res;
        return res;
    }
}
