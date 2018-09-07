public class S0540SingleElementSortedArray {
    public int singleNonDuplicate(int[] nums) {
        return single(nums, 0, nums.length);
    }

    // [start, end)
    private int single(int[] nums, int start, int end) {
        assert end > start;
        if (end - start == 1) {
            return nums[start];
        }
        int len = end - start;
        assert len % 2 == 1;
        int half = start + len / 2;
        if (nums[half-1] != nums[half] && nums[half] != nums[half+1]) {
            return nums[half];
        }

        if (half%2 == 0) { // even half
            if (nums[half-1] == nums[half]) {
                return single(nums, start, half-1);
            } else {
                return single(nums, half, end);
            }
        } else { // odd half
            if (nums[half-1] == nums[half]) {
                return single(nums, half+1, end);
            } else {
                return single(nums, start, half);
            }
        }
    }
}
