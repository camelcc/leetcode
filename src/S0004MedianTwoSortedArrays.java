public class S0004MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        if (nums1.length == 0) {
            if (nums2.length == 0) {
                return 0;
            } else if (nums2.length == 1) {
                return nums2[0];
            }
            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length/2-1]+nums2[nums2.length/2])/2.0;
            } else {
                return nums2[nums2.length/2];
            }
        }
        int len = nums1.length+nums2.length;

        int lo1 = 0, hi1 = nums1.length;
        while (lo1 <= hi1) {
            int i = (lo1+hi1)/2;
            int j = (len+1)/2-i;
            if (i < nums1.length && nums2[j-1] > nums1[i]) {
                lo1 = i+1;
            } else if (i > 0 && nums1[i-1] > nums2[j]) {
                hi1 = i-1;
            } else {
                int lmax;
                if (i == 0) {
                    lmax = nums2[j-1];
                } else if (j == 0) {
                    lmax = nums1[i-1];
                } else {
                    lmax = Math.max(nums1[i-1], nums2[j-1]);
                }
                int rmin;
                if (i == nums1.length) {
                    rmin = nums2[j];
                } else if (j == nums2.length) {
                    rmin = nums1[i];
                } else {
                    rmin = Math.min(nums1[i], nums2[j]);
                }
                if (len%2 != 0) {
                    return lmax;
                } else {
                    return (lmax+rmin)/2.0;
                }
            }
        }
        return 0;
    }
}
