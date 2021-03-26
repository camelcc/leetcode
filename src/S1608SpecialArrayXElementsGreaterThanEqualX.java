import java.util.Arrays;

public class S1608SpecialArrayXElementsGreaterThanEqualX {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int lo = 0, hi = nums[nums.length-1];
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int p = Arrays.binarySearch(nums, mid);
            if (p < 0) {
                p = -(p+1);
            } else {
                while (p > 0 && nums[p-1] == mid) {
                    p--;
                }
            }
            int len = nums.length-p;
            if (len < mid) {
                hi = mid-1;
            } else if (len == mid) {
                return mid;
            } else { // len > mid
                lo = mid+1;
            }
        }
        return -1;
    }
}
