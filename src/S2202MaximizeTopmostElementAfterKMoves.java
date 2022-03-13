public class S2202MaximizeTopmostElementAfterKMoves {
    public int maximumTop(int[] nums, int k) {
        if (nums.length == 1) {
            if (k%2 == 1) {
                return -1;
            } else {
                return nums[0];
            }
        }
        if (k > nums.length) {
            int max = nums[0];
            for (int n : nums) {
                max = Math.max(max, n);
            }
            return max;
        }
        if (k == 1) {
            return nums[1];
        }
        // k > 1, nums.length > 1, k <= nums.length
        int max = nums[0];
        for (int i = 0; i < k-1; i++) {
            max = Math.max(max, nums[i]);
        }
        if (k == nums.length) {
            return max;
        }
        // k < nums.length
        return Math.max(max, nums[k]);
    }
}
