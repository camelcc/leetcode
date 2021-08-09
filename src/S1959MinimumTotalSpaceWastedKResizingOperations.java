public class S1959MinimumTotalSpaceWastedKResizingOperations {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int s = 0;
        int[] sum = new int[nums.length+1];
        int[][] max = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = s;
            max[i][i] = nums[i];
            for (int j = 0; j < i; j++) {
                max[j][i] = Math.max(max[j][i-1], nums[i]);
            }
            s += nums[i];
        }
        sum[nums.length] = s;
        Integer[][][] dp = new Integer[nums.length+1][nums.length+1][k+1];
        return min(sum, max, 0, nums.length, k, dp);
    }

    private int min(int[] sum, int[][] max, int lo, int hi, int k, Integer[][][] dp) {
        if (lo == hi-1) {
            return 0;
        }
        if (dp[lo][hi][k] != null) {
            return dp[lo][hi][k];
        }
        if (k == 0) {
            dp[lo][hi][k] = max[lo][hi-1]*(hi-lo)-(sum[hi]-sum[lo]);
            return dp[lo][hi][k];
        }
        int res = Integer.MAX_VALUE;
        for (int split = lo+1; split < hi; split++) {
            int r = min(sum, max, lo, split, 0, dp) + min(sum, max, split, hi, k-1, dp);
            res = Math.min(res, r);
        }
        dp[lo][hi][k] = res;
        return res;
    }
}
