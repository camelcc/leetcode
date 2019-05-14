public class S0410SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        long[] sum = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        long[][] dp = new long[nums.length][m];
        return (int)split(nums, sum, dp, 0, m);
    }

    private long split(int[] nums, long[] sum, long[][] dp, int start, int m) {
        assert nums.length-start >= m;
        assert m > 0;
        assert start < nums.length;
        if (dp[start][m-1] != 0) {
            return dp[start][m-1];
        }

        if (m == 1) {
            dp[start][m-1] = sum[nums.length]-sum[start];
            return dp[start][m-1];
        }

        long res = Integer.MAX_VALUE;
        int lo = start, hi = nums.length-m;
        while (lo <= hi) {
            int mid = (lo+hi)/2;
            long left = sum[mid+1]-sum[start];
            long right = split(nums, sum, dp, mid+1, m-1);
            res = Math.min(res, Math.max(left, right));
            if (left == right) {
                res = left;
                break;
            }

            if (left < right) {
                lo = mid+1;
            } else { // right > left
                hi = mid-1;
            }
        }

        dp[start][m-1] = res;
        return res;
    }
}
