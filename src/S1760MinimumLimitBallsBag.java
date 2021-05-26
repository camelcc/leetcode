import java.util.Arrays;

public class S1760MinimumLimitBallsBag {
    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int lo = 1, hi = nums[nums.length-1]+1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            int p = Arrays.binarySearch(nums, mid);
            if (p < 0) {
                p = -(p+1);
            }
            int cnt = 0;
            for (int i = p; i < nums.length; i++) {
                if (nums[i] == mid) {
                    continue;
                }
                cnt += (int)Math.ceil(nums[i]*1.0/mid) - 1;
            }
            if (cnt < maxOperations) {
                if (lo == mid) {
                    return mid;
                }
                hi = mid;
            } else if (cnt == maxOperations) {
                hi = mid;
            } else { // cnt > max
                lo = mid+1;
            }
        }
        return lo;
    }
}
