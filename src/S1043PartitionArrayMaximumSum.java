import java.util.Arrays;

public class S1043PartitionArrayMaximumSum {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        int[][] max = new int[N][N];
        max[0][0] = A[0];
        for (int i = 0; i < N; i++) {
            for (int j = Math.max(i, 1); j < N; j++) {
                max[i][j] = Math.max(max[i][j-1], A[j]);
            }
        }
        return max(A, 0, N-1, K, max, dp);
    }

    private int max(int[] A, int start, int end, int K, int[][] max, int[][] dp) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int res = 0;
        for (int mid = start; mid <= end && mid < start+K; mid++) {
            int r = max[start][mid]*(mid-start+1);
            r += max(A, mid+1, end, K, max, dp);
            res = Math.max(res, r);
        }
        dp[start][end] = res;
        return res;
    }
}
