public class S0031NextPermutation {
    public void nextPermutation(int[] nums) {
        int decrease = nums.length-2;
        while (decrease >= 0 && nums[decrease] >= nums[decrease+1]) {
            decrease--;
        }
        if (decrease >= 0) {
            int j = nums.length-1;
            while (nums[j] <= nums[decrease]) {
                j--;
            }
            int t = nums[decrease];
            nums[decrease] = nums[j];
            nums[j] = t;
        }
        // reverse [decrease+1, end]
        int lo = decrease+1, hi = nums.length-1;
        while (lo < hi) {
            int t = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = t;
            lo++;
            hi--;
        }
    }
}
