import java.util.Arrays;

public class S0329LongestIncreasingPathMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int M = matrix.length, N = matrix[0].length;
        int res = 0;
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                res = Math.max(res, len(matrix, r, c, dp));
            }
        }
        return res;
    }

    private int len(int[][] matrix, int r, int c, int[][] dp) {
        if (dp[r][c] >= 0) {
            return dp[r][c];
        }

        int res = 1;
        int v = matrix[r][c];
        // left
        if (c > 0 && matrix[r][c-1] > v) {
            res = Math.max(res, 1+len(matrix, r, c-1, dp));
        }
        // up
        if (r > 0 && matrix[r-1][c] > v) {
            res = Math.max(res, 1+len(matrix, r-1, c, dp));
        }
        // right
        if (c < matrix[0].length-1 && matrix[r][c+1] > v) {
            res = Math.max(res, 1+len(matrix, r, c+1, dp));
        }
        // down
        if (r < matrix.length-1 && matrix[r+1][c] > v) {
            res = Math.max(res, 1+len(matrix, r+1, c, dp));
        }
        dp[r][c] = res;
        return res;
    }
}
