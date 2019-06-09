public class S0063UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;
        int[][] dp = new int[M][N];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < N; i++) {
            dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i-1];
        }
        for (int i = 1; i < M; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i-1][0];
        }
        for (int r = 1; r < M; r++) {
            for (int c = 1; c < N; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                } else {
                    dp[r][c] = dp[r-1][c] + dp[r][c-1];
                }
            }
        }
        return dp[M-1][N-1];
    }
}
