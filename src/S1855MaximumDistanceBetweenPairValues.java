public class S1855MaximumDistanceBetweenPairValues {
    public int maxDistance(int[] nums1, int[] nums2) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (i >= nums2.length || nums1[i] > nums2[i]) {
                continue;
            }
            int lo = i, hi = nums2.length;
            while (lo < hi) {
                int mid = lo + (hi-lo)/2;
                if (nums1[i] <= nums2[mid]) {
                    if (lo == mid) {
                        break;
                    }
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
            res = Math.max(res, lo-i);
        }
        return res;
    }
}
