public class S0689MaximumSum3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][] dp2 = new int[nums.length][2];
        int[] dp1 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp2[i][0] = -1;
            dp2[i][1] = -1;
            dp1[i] = -1;
        }
        long[] sum = new long[nums.length+1];
        long acc = 0;
        for (int i = 0; i < nums.length; i++) {
            acc += nums[i];
            sum[i+1] = acc;
        }

        int[] res = new int[] {-1, -1, -1};
        long s = 0;
        for (int first = 0; first < sum.length-3*k; first++) {
            int[] st = maxTwoSubarray(sum, first+k, k, dp2, dp1);
            long total = sum[first+k]-sum[first]+sum[st[0]+k]-sum[st[0]]+sum[st[1]+k]-sum[st[1]];
            if (total > s) {
                s = total;
                res[0] = first;
                res[1] = st[0];
                res[2] = st[1];
            }
        }
        return res;
    }

    private int[] maxTwoSubarray(long[] sum, int start, int k, int[][] dp2, int[] dp1) {
        assert start < sum.length-2*k;
        if (dp2[start][0] != -1) {
            return dp2[start];
        }

        int[] res = new int[] {-1, -1};
        long s = 0;
        for (int first = start; first < sum.length-2*k; first++) {
            int second = maxSubarray(sum, first+k, k, dp1);
            long total = sum[first+k]-sum[first]+sum[second+k]-sum[second];
            if (total > s) {
                s = total;
                res[0] = first;
                res[1] = second;
            }
        }
        dp2[start][0] = res[0];
        dp2[start][1] = res[1];
        return res;
    }

    private int maxSubarray(long[] sum, int start, int k, int[] dp) {
        assert start < sum.length-k;
        if (dp[start] != -1) {
            return dp[start];
        }

        int res = start;
        for (int i = start; i < sum.length-k; i++) {
            if (sum[i+k]-sum[i] > sum[res+k]-sum[res]) {
                res = i;
            }
        }
        dp[start] = res;
        return res;
    }
}
