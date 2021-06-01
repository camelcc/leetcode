public class S1800MaximumAscendingSubarraySum {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int cur = 0, sum = 0;
        for (int n : nums) {
            if (n > cur) {
                sum += n;
                cur = n;
            } else {
                res = Math.max(res, sum);
                cur = n;
                sum = n;
            }
        }
        res = Math.max(res, sum);
        return res;
    }
}
