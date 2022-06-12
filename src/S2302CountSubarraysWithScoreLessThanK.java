public class S2302CountSubarraysWithScoreLessThanK {
    public long countSubarrays(int[] nums, long k) {
        long[] sum = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i]+nums[i];
        }

        long res = 0;
        for (int i = 1; i < sum.length; i++) {
            int lo = 0, hi = i;
            while (lo < hi) {
                int mid = lo+(hi-lo)/2;
                if ((sum[i] - sum[mid]) * (i - mid) >= k) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }
            res += (i-lo);
        }
        return res;
    }
}
