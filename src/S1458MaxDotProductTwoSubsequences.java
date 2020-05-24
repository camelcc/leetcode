public class S1458MaxDotProductTwoSubsequences {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        Integer[][] dp = new Integer[nums1.length][nums2.length];
        return dot(nums1, nums2, 0, 0, dp);
    }

    private int dot(int[] nums1, int[] nums2, int i1, int i2, Integer[][] dp) {
        if (dp[i1][i2] != null) {
            return dp[i1][i2];
        }
        int res = Integer.MIN_VALUE;
        if (i1 == nums1.length-1) {
            for (int i = i2; i < nums2.length; i++) {
                res = Math.max(res, nums1[i1]*nums2[i]);
            }
            dp[i1][i2] = res;
            return res;
        }
        if (i2 == nums2.length-1) {
            for (int i = i1; i < nums1.length; i++) {
                res = Math.max(res, nums1[i]*nums2[i2]);
            }
            dp[i1][i2] = res;
            return res;
        }
        // i1 != nums1.len-1, i2 != nums2.len-1
        res = Math.max(res, nums1[i1]*nums2[i2]);
        res = Math.max(res, nums1[i1]*nums2[i2]+dot(nums1, nums2, i1+1, i2+1, dp));
        res = Math.max(res, dot(nums1, nums2, i1, i2+1, dp));
        res = Math.max(res, dot(nums1, nums2, i1+1, i2, dp));
        dp[i1][i2] = res;
        return res;
    }
}
