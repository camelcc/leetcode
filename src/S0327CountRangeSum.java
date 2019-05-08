import java.util.Arrays;

public class S0327CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i+1] = s;
        }
        return range(sum, 0, nums.length+1, lower, upper);
    }

    // [lower, upper]
    private int range(long[] sum, int lo, int hi, int lower, int upper) {
        if (lo + 1 >= hi) {
            return 0;
        }
        int mid = (lo+hi)/2;
        int cnt = lo+1 == hi ? 0 : range(sum, lo, mid, lower, upper) +
                range(sum, mid, hi, lower, upper);
        for (int i = lo; i < mid; i++) {
            int rl = mid;
            while (rl < hi && sum[rl]-sum[i] < lower) {
                rl++;
            }
            int rr = mid;
            while (rr < hi && sum[rr]-sum[i] <= upper) {
                rr++;
            }
            cnt += rr-rl;
        }
        Arrays.sort(sum, lo, hi);
        return cnt;
    }
}
