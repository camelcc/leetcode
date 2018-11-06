public class S0200NumberIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                cnt++;
                dfs(grid, M, N, i, j);
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int M, int N, int r, int c) {
        if (r < 0 || r >= M || c < 0 || c >= N || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, M, N, r, c-1);
        dfs(grid, M, N, r-1, c);
        dfs(grid, M, N, r, c+1);
        dfs(grid, M, N, r+1, c);
    }
}
