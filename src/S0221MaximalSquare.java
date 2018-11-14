public class S0221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int M = matrix.length, N = matrix[0].length;

        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] != '0'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                }
                if (dp[i][j] > res) {
                    res = dp[i][j];
                }
            }
        }
        return res * res;
    }
}
