public class S1219PathMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int res = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] != 0) {
                    res = Math.max(res, dfs(grid, new int[]{r, c}, new boolean[M][N]));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int[] p, boolean[][] visited) {
        int M = grid.length, N = grid[0].length;
        int r = p[0], c = p[1];
        if (r < 0 || r >= M || c < 0 || c >= N || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }
        int res = grid[r][c];
        visited[r][c] = true;
        for (int[] dir : new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}}) {
            int t = dfs(grid, new int[]{r+dir[0], c+dir[1]}, visited);
            res = Math.max(res, grid[r][c]+t);
        }
        visited[r][c] = false;
        return res;
    }
}
