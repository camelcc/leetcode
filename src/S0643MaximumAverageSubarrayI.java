public class S0643MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        long maxSum = Long.MIN_VALUE;
        int preVal = 0;
        long preSum = 0;
        for (int i = 0; i < k-1; i++) {
            preSum += nums[i];
        }

        for (int i = 0; i <= nums.length-k; i++) {
            long sum = preSum - preVal + nums[i+k-1];
            if (sum > maxSum) {
                maxSum = sum;
            }
            preSum = sum;
            preVal = nums[i];
        }
        return 1.0*maxSum/k;
    }
}
