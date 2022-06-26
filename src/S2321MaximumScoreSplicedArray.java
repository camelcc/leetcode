public class S2321MaximumScoreSplicedArray {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int N = nums1.length;
        int[] sum1 = new int[nums1.length+1];
        int[] sum2 = new int[nums2.length+1];
        for (int i = 0; i < N; i++) {
            sum1[i+1] = sum1[i] + nums1[i];
            sum2[i+1] = sum2[i] + nums2[i];
        }
        int res = Math.max(sum1[N], sum2[N]);
        int max1 = 0, max2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            int s1 = sum1[N]-sum1[i+1];
            int s2 = sum2[N]-sum2[i+1];
            max1 = Math.max(max1+nums2[i], sum1[i]+nums2[i]);
            max2 = Math.max(max2+nums1[i], sum2[i]+nums1[i]);
            res = Math.max(res, Math.max(max1+s1, max2+s2));
        }
        return res;
    }
}
