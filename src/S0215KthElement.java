public class S0215KthElement {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length-k;
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j+1;
            } else if (j > k) {
                hi = j-1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int lo, int hi) {
        int l = lo+1, r = hi;
        while (true) {
            while (l < hi && nums[l] < nums[lo]) {
                l++;
            }
            while (r > lo && nums[lo] < nums[r]) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
        int t = nums[lo];
        nums[lo] = nums[r];
        nums[r] = t;
        return r;
    }
}
