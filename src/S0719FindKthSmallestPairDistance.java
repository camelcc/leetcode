import java.util.Arrays;

public class S0719FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int N = nums.length;
        int diffLo = 0, diffHi = nums[N-1]-nums[0];
        while (diffLo < diffHi) {
            int diff = diffLo + (diffHi-diffLo)/2;
            int cnt = 0;
            for (int start = 0; start <= N-2; start++) {
                if (nums[start+1]-nums[start] > diff) {
                    continue;
                }
                cnt += diff(nums, start, diff);
            }
            if (cnt < k) {
                diffLo = diff+1;
            } else if (cnt == k) {
                diffHi = diff;
            } else {
                diffHi = diff;
            }
        }
        return diffHi;
    }

    private int diff(int[] nums, int start, int diff) {
        int lo = start+1, hi = nums.length;
        while (lo < hi) {
            int mid = lo+(hi-lo)/2;
            int d = nums[mid]-nums[start];
            if (d <= diff) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return hi-start-1;
    }
}
