public class S0152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int res = nums[0];
        int[] maxDP = new int[nums.length];
        maxDP[0] = nums[0];
        int[] minDP = new int[nums.length];
        minDP[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxDP[i] = Math.max(Math.max(maxDP[i-1] * nums[i], minDP[i-1] * nums[i]), nums[i]);
            minDP[i] = Math.min(Math.min(maxDP[i-1] * nums[i], minDP[i-1] * nums[i]), nums[i]);
            res = Math.max(maxDP[i], res);
        }

        return res;
    }
}
