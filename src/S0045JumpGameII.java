public class S0045JumpGameII {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;
        for (int i = nums.length-2; i >= 0; i--) {
            int min = nums.length;
            for (int j = i+1; j <= i+nums[i] && j < nums.length; j++) {
                min = Math.min(min, 1 + dp[j]);
            }
            dp[i] = min;
        }

        return dp[0];
    }
}
