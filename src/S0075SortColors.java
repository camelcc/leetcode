public class S0075SortColors {
    public void sortColors(int[] nums) {
        int lo = 0, hi = nums.length-1;
        int left = -1;

        while (lo <= hi) {
            if (nums[lo] == 0) {
                if (left == -1) {
                    lo++;
                } else {
                    swap(nums, left, lo);
                    left++;
                    lo++;
                }
            } else if (nums[lo] == 1) {
                if (left == -1) {
                    left = lo;
                    lo++;
                } else {
                    lo++;
                }
            } else if (nums[lo] == 2) {
                swap(nums, lo, hi);
                hi--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
