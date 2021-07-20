// https://leetcode.com/problems/maximum-number-of-points-with-cost/discuss/1344870/Java-DP
public class S1937MaximumNumberPointsCost {
    public long maxPoints(int[][] points) {
        int M = points.length, N = points[0].length;
        long[] dp = new long[N];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                dp[c] = dp[c] + points[r][c];
            }
            for(int c = 1; c < N; c++){
                dp[c] = Math.max(dp[c], dp[c-1] - 1);
            }
            for(int c = N-2; c >= 0; c--){
                dp[c] = Math.max(dp[c], dp[c+1] - 1);
            }
        }
        long res = 0;
        for (int c = 0; c < N; c++) {
            res = Math.max(res, dp[c]);
        }
        return res;
    }
}
