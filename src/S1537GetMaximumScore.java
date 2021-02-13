public class S1537GetMaximumScore {
    public int maxSum(int[] nums1, int[] nums2) {
        int MOD = (int)(Math.pow(10, 9) + 7);
        Long[] dp1 = new Long[nums1.length];
        Long[] dp2 = new Long[nums2.length];
        long res1 = dp(nums1, nums2, dp1, dp2, 0, 0);
        dp1 = new Long[nums1.length];
        dp2 = new Long[nums2.length];
        long res2 = dp(nums2, nums1, dp2, dp1, 0, 0);
        return (int)(Math.max(res1, res2)%MOD);
    }

    private long dp(int[] nums1, int[] nums2, Long[] dp1, Long[] dp2, int p, int np) {
        if (p >= nums1.length) {
            return 0;
        }
        if (dp1[p] != null) {
            return dp1[p];
        }
        long res = nums1[p];
        while (np < nums2.length && nums2[np] < nums1[p]) {
            np++;
        }
        if (np >= nums2.length) {
            for (int i = p+1; i < nums1.length; i++) {
                res += nums1[i];
            }
            return res;
        }
        // nums2[np] >= nums1[p]
        // nums2[np] > nums1[p], choose p
        long max = dp(nums1, nums2, dp1, dp2, p+1, np);
        // choose alternative
        if (nums2[np] == nums1[p]) {
            max = Math.max(max, dp(nums2, nums1, dp2, dp1, np+1, p+1));
        }
        res += max;
        dp1[p] = res;
        return res;
    }
}
