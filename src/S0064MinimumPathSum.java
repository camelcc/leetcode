public class S0064MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;
        int[][] sum = new int[M][N];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < N; i++) {
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < M; i++) {
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }

        for (int level = 1; level < Math.min(M, N); level++) {
            sum[level][level] = Math.min(sum[level-1][level], sum[level][level-1]) + grid[level][level];
            for (int i = level+1; i < N; i++) {
                sum[level][i] = Math.min(sum[level][i-1], sum[level-1][i]) + grid[level][i];
            }
            for (int i = level+1; i < M; i++) {
                sum[i][level] = Math.min(sum[i-1][level], sum[i][level-1]) + grid[i][level];
            }
        }
        return sum[M-1][N-1];
    }
}
