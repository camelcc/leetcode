public class S0004MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int s = 0;
        int e = n1;

        while(s <= e){
            int p1 = s + (e-s) / 2;
            int p2 = ((n1 + n2) / 2) - p1;

            int l1 = p1==0 ? Integer.MIN_VALUE : nums1[p1-1];
            int l2 = p2==0 ? Integer.MIN_VALUE : nums2[p2-1];

            int r1 = p1==nums1.length ? Integer.MAX_VALUE : nums1[p1];
            int r2 = p2==nums2.length ? Integer.MAX_VALUE : nums2[p2];

            if(l1 <= r2 && l2 <= r1){
                int l = Math.max(l1, l2);
                int r = Math.min(r1, r2);

                if((n1+n2) % 2==0){
                    return (l+r) / 2.0;
                }else{
                    return r * 1.0;
                }
            }else if(l1 > r2){
                e = p1 - 1;
            }else{
                s = p1 + 1;
            }
        }

        return -1;
    }
}
