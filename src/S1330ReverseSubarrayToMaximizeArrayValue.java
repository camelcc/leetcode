public class S1330ReverseSubarrayToMaximizeArrayValue {
    public int maxValueAfterReverse(int[] nums) {
        int total = 0, res = 0, min2 = 123456, max2 = -123456, n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            int a = nums[i], b = nums[i + 1];
            total += Math.abs(a - b);
            res = Math.max(res, Math.abs(nums[0] - b) - Math.abs(a - b));
            res = Math.max(res, Math.abs(nums[n - 1] - a) - Math.abs(a - b));
            min2 = Math.min(min2, Math.max(a, b));
            max2 = Math.max(max2, Math.min(a, b));
        }
        return total + Math.max(res, (max2 - min2) * 2);
    }
}
