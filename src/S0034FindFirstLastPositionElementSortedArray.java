public class S0034FindFirstLastPositionElementSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        if (nums[lo] != target) {
            return new int[]{-1, -1};
        }
        int left = lo;
        if (nums[nums.length-1] == target) {
            return new int[]{left, nums.length-1};
        }
        lo = 0;
        hi = nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] <= target) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return new int[]{left, lo-1};
    }
}
