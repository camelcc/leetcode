public class S0053MaxSubarray {
    // TODO: DP and Divide & conqur
    public int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                sums[j] += nums[i];
                if (sums[j] > max) {
                    max = sums[j];
                }
            }
        }
        return max;
    }
}
