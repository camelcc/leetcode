public class S1911MaximumAlternatingSubsequenceSum {
    public long maxAlternatingSum(int[] nums) {
        Long[] max = new Long[nums.length];
        Long[] min = new Long[nums.length];
        return max(nums, 0, max, min);
    }

    private long max(int[] nums, int p, Long[] max, Long[] min) {
        if (p >= nums.length) {
            return 0;
        }
        if (max[p] != null) {
            return max[p];
        }
        if (p == nums.length-1) {
            max[p] = Math.max(0, (long)nums[p]);
            min[p] = 0L;
            return max[p];
        }
        long res = max(nums, p+1, max, min);
        res = Math.max(res, nums[p]);
        // pick
        res = Math.max(res, nums[p]-min(nums, p+1, max, min));
        max[p] = res;
        return res;
    }

    private long min(int[] nums, int p, Long[] max, Long[] min) {
        if (p >= nums.length) {
            return 0;
        }
        if (min[p] != null) {
            return min[p];
        }
        if (p == nums.length-1) {
            min[p] = 0L;
            return min[p];
        }
        long res = min(nums, p+1, max, min);
        res = Math.min(res, nums[p]);
        // pick
        res = Math.min(res, nums[p]-max(nums, p+1, max, min));
        min[p] = res;
        return res;
    }
}
