public class S1749MaximumAbsoluteSumAnySubarray {
    public int maxAbsoluteSum(int[] nums) {
        int res = 0;
        int min = 0, max = 0;
        for (int r = 0; r < nums.length; r++) {
            min = Math.min(min+nums[r], nums[r]);
            max = Math.max(max+nums[r], nums[r]);
            res = Math.max(res, Math.max(Math.abs(min), Math.abs(max)));
        }
        return res;
    }
}
