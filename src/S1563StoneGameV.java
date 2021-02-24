public class S1563StoneGameV {
    public int stoneGameV(int[] stoneValue) {
        Integer[][] dp = new Integer[stoneValue.length][stoneValue.length];
        int[] sum = new int[stoneValue.length+1];
        int s = 0;
        for (int i = 0; i < stoneValue.length; i++) {
            s += stoneValue[i];
            sum[i+1] = s;
        }
        return dp(sum, 0, stoneValue.length-1, dp);
    }

    private int dp(int[] sum, int start, int end, Integer[][] dp) {
        if (start == end) {
            dp[start][end] = 0;
            return 0;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        int max = 0;
        for (int i = start+1; i <= end; i++) {
            int res = 0;
            int left = sum[i]-sum[start];
            int right = sum[end+1]-sum[i];
            if (left < right) {
                res = left + dp(sum, start, i-1, dp);
            } else if (left == right) {
                res = left + Math.max(dp(sum, start, i-1, dp),
                        dp(sum, i, end, dp));
            } else { // left > right
                res = right + dp(sum, i, end, dp);
            }
            max = Math.max(max, res);
        }
        dp[start][end] = max;
        return max;
    }
}
