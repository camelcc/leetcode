public class S0189RotateArray {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if (k == 0) {
            return;
        }

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        int lo = start, hi = end;
        while (lo < hi) {
            int tmp = nums[hi];
            nums[hi] = nums[lo];
            nums[lo] = tmp;
            hi--;
            lo++;
        }
    }
}
