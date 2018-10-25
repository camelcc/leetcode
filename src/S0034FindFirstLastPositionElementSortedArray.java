public class S0034FindFirstLastPositionElementSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        int le = -1, ge = -1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] < target) {
                lo = mid+1;
            } else if (nums[mid] == target) {
                le = mid;
                ge = mid;
                break;
            } else { // nums[mid] > target
                hi = mid-1;
            }
        }
        if (le == -1) {
            return new int[]{-1, -1};
        }

        lo = 0;
        while (lo < le) {
            int mid = lo + (le-lo)/2;
            if (nums[mid] < target) {
                lo = mid+1;
            } else if (nums[mid] == target) {
                le = mid;
            } else {
                throw new IllegalStateException("invalid");
            }
        }

        hi = nums.length-1;
        while (hi > ge) {
            int mid = ge + (hi-ge)/2 + 1;
            if (nums[mid] < target) {
                throw new IllegalStateException("invalid");
            } else if (nums[mid] == target) {
                ge = mid;
            } else {
                hi = mid-1;
            }
        }
        return new int[] {le, ge};
    }
}
