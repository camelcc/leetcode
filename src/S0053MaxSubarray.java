public class S0053MaxSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int localMax = nums[0];
        int globalMax = nums[0];

        for ( int i = 1; i < nums.length ; i++ ){
            localMax = Math.max(nums[i] + localMax , nums[i]);
            globalMax = Math.max(localMax, globalMax);
        }

        return globalMax;
    }
}
