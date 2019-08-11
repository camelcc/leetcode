import java.util.Arrays;

public class S1150CheckIfNumberIsMajorityElementSortedArray {
    public boolean isMajorityElement(int[] nums, int target) {
        int p = Arrays.binarySearch(nums, target);
        if (p == -1) {
            return false;
        }

        int lo = 0, hi = p;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] < target) {
                lo = mid+1;
            } else {
                assert nums[mid] == target;
                hi = mid;
            }
        }
        int left = hi;

        lo = p;
        hi = nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (nums[mid] > target) {
                hi = mid-1;
            } else {
                assert nums[mid] == target;
                lo = mid;
            }
        }
        int right = lo;

        return (right-left+1) > nums.length/2;
    }
}
