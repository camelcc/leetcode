public class S2239FindClosestNumberZero {
    public int findClosestNumber(int[] nums) {
        int res = nums[0];
        for (int n : nums) {
            int d = Math.abs(n);
            if (d < Math.abs(res)) {
                res = n;
            } else if (d == Math.abs(res)) {
                res = Math.max(res, n);
            }
        }
        return res;
    }
}
