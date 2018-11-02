public class S0162FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] > nums[mid+1]) {
                hi = mid;
            } else { // mid < mid+1
                lo = mid+1;
            }
        }
        return lo;
    }
}
