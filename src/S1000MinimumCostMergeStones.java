public class S1000MinimumCostMergeStones {
    public int mergeStones(int[] stones, int K) {
        int N = stones.length;
        if ((N-1)%(K-1) != 0) {
            return -1;
        }
        int[] sum = new int[N+1];
        for (int i = 0; i < N; i++) {
            sum[i+1] = sum[i] + stones[i];
        }
        int[][][] dp = new int[N][N][K+1];
        return merge(stones, K, 0, N-1, 1, sum, dp);
    }

    private int merge(int[] stones, int K, int start, int end, int target, int[] sum, int[][][] dp) {
        if (dp[start][end][target] != 0) {
            return dp[start][end][target];
        }
        if (start == end) {
            dp[start][end][target] = target == 1 ? 0 : -1;
            return target == 1 ? 0 : -1;
        }
        if (target == 1) {
            int t = merge(stones, K, start, end, K, sum, dp);
            dp[start][end][target] = t < 0 ? -1 : t+sum[end+1]-sum[start];
            return dp[start][end][target];
        }

        int res = -1;
        for (int mid = start; mid < end; mid++) {
            int left = merge(stones, K, start, mid, target-1, sum, dp);
            if (left == -1) {
                continue;
            }
            int right = merge(stones, K, mid+1, end, 1, sum, dp);
            if (right == -1) {
                continue;
            }
            if (res == -1) {
                res = left+right;
            } else {
                res = Math.min(res, left+right);
            }
        }

        dp[start][end][target] = res;
        return dp[start][end][target];
    }
}
