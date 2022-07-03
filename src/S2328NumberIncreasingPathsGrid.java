public class S2328NumberIncreasingPathsGrid {
    public int countPaths(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        Long[][] dp = new Long[M][N];
        int MOD = 1_000_000_007;
        long res = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                res = (res + dfs(grid, r, c, dp))%MOD;
            }
        }
        return (int)res;
    }

    private long dfs(int[][] grid, int r, int c, Long[][] dp) {
        if (dp[r][c] != null) {
            return dp[r][c];
        }

        int M = grid.length, N = grid[0].length;
        int MOD = 1_000_000_007;
        long res = 1;
        for (int[] dir : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
            int nr = r+dir[0], nc = c+dir[1];
            if (nr < 0 || nr >= M || nc < 0 || nc >= N || grid[nr][nc] <= grid[r][c]) {
                continue;
            }
            res = (res + dfs(grid, nr, nc, dp))%MOD;
        }
        dp[r][c] = res;
        return res;
    }
}
