public class S0033SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] > nums[hi]) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        int pivot = lo;
        lo = 0;
        hi = nums.length-1;
        while (lo <= hi) {
            int mid = lo+(hi-lo)/2;
            int v = nums[(mid+pivot)%nums.length];
            if (v < target) {
                lo = mid+1;
            } else if (v == target) {
                return (mid+pivot)%nums.length;
            } else {
                hi = mid-1;
            }
        }
        return -1;
    }
}
