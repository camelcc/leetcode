public class S0912SortanArray {
    public int[] sortArray(int[] nums) {
        quick(nums, 0, nums.length-1);
        return nums;
    }

    private void quick(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int lo = start+1, hi = end;
        while (lo <= hi) {
            while (lo <= end && nums[lo] < nums[start]) {
                lo++;
            }
            while (hi >= start+1 && nums[hi] >= nums[start]) {
                hi--;
            }
            if (lo >= hi) {
                break;
            }

            int t = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = t;
        }

        int t = nums[hi];
        nums[hi] = nums[start];
        nums[start] = t;
        quick(nums, start, hi-1);
        quick(nums, hi+1, end);
    }
}
