import java.util.Arrays;

public class S1712WaysSplitArrayIntoThreeSubarrays {
    public int waysToSplit(int[] nums) {
        int[] sum = new int[nums.length];
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i] = s;
        }

        int MOD = 1_000_000_007;
        long res = 0;
        for (int i = 0; i < nums.length && sum[i]*3<= s; i++) {
            int left = sum[i];
            int lo = bs(sum, i+1, sum.length, 2*left);
            if (lo >= nums.length) {
                break;
            }

            int hi = bs(sum, i+1, sum.length, left+(s-left)/2+1);
            hi--;
            if (hi > nums.length-2) {
                hi = nums.length-2;
            }
            if (lo > hi) {
                continue;
            }
            res = (res + (hi-lo+1))%MOD;
        }
        return (int)res;
    }

    // first res: sum[res] >= v
    private int bs(int[] sum, int lo, int hi, int v) {
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (sum[mid] < v) {
                lo = mid+1;
            } else if (sum[mid] == v) {
                if (mid == lo || sum[mid] > sum[mid-1]) {
                    return mid;
                }
                hi = mid;
            } else { // sum[mid] > v
                hi = mid;
            }
        }
//      first value that sum[lo] >= v
        return lo;
    }
}
