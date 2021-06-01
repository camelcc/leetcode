public class S1802MaximumValueGivenIndexBoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        int lo = 1, hi = maxSum+1, left = index, right = n-1-index;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            long sl = 0, sr = 0;
            if (mid-left >= 1) {
                sl = ((long)mid-left+mid)*(left+1)/2;
            } else {
                sl = (1L+mid)*mid/2 + left-(mid-1);
            }
            if (mid-right >= 1) {
                sr = ((long)mid-right+mid)*(right+1)/2;
            } else {
                sr = (1L+mid)*mid/2 + right-(mid-1);
            }
            long s = sl+sr-mid;
            if (s <= maxSum) {
                if (mid == lo) {
                    return mid;
                }
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
