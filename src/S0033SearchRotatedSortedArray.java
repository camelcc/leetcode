import java.util.Arrays;

public class S0033SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int pos = pivot(nums, 0, nums.length-1);
        int last = nums[nums.length-1];
        if (target == last) {
            return nums.length-1;
        } else if (target > last) {
            // first half
            int p = Arrays.binarySearch(nums, 0, pos, target);
            return p < 0 ? -1 : p;
        } else {
            int p = Arrays.binarySearch(nums, pos, nums.length, target);
            return p < 0 ? -1 : p;
        }
    }

    // log(n)
    private int pivot(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return lo;
        }
        int mid = (lo+hi)/2;
        int val = nums[hi];
        if (nums[mid] > val) {
            return pivot(nums, mid+1, hi);
        } else {
            return pivot(nums, lo, mid);
        }
    }
}
