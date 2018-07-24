public class S0153MinRotatedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0, end = nums.length-1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid+1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            }
        }
        return nums[end];
    }
}
