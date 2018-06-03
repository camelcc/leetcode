public class S0035SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = nums[mid] - target;
            if (cmp < 0) {
                lo = mid+1;
            } else if (cmp > 0) {
                hi = mid-1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}
