public class S2016MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int res = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                res = Math.max(res, nums[i]-min);
            }
            min = Math.min(min, nums[i]);
        }
        return res;
    }
}
