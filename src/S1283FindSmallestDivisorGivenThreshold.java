import java.util.Arrays;

public class S1283FindSmallestDivisorGivenThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int lo = 1, hi = nums[nums.length-1];
        while (lo <= hi) {
            if (lo == hi) {
                return lo;
            }

            // lo < hi
            int mid = lo + (hi-lo)/2;
            int s = sum(nums, mid);
            if (s <= threshold) {
                if (lo == mid) {
                    return mid;
                }
                hi = mid;
            } else {
                lo = mid+1;
            }
        }

        return lo;
    }

    private int sum(int[] nums, int d) {
        int s = 0;
        for (int num : nums) {
            s += Math.ceil(num*1.0/d);
        }
        return s;
    }
}
