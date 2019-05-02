public class S0154FindMinimumRotatedSortedArrayII {
    public int findMin(int[] nums) {
        return min(nums, 0, nums.length-1);
    }

    private int min(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int l = start, r = end;
        while (start < end) {
            int mid = (start+end)/2;
            if (nums[mid] > nums[end]) {
                start = mid+1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                return Math.min(min(nums, start, mid),
                        min(nums, mid+1, end));
            }
        }
        return nums[end];
    }
}
