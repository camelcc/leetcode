public class S0803BricksFallingWhenHit {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int M = grid.length, N = grid[0].length;
        int[] res = new int[hits.length];
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]]--;
        }
        for (int c = 0; c < N; c++) {
            dfs(grid, 0, c);
        }
        for (int i = hits.length-1; i >= 0; i--) {
            int r = hits[i][0], c = hits[i][1];
            grid[r][c]++;
            if (grid[r][c] == 1 && connected(grid, r, c)) {
                res[i] = dfs(grid, r, c)-1;
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int r, int c) {
        int M = grid.length, N = grid[0].length;
        if (r < 0 || r >= M || c < 0 || c >= N || grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return 1+dfs(grid, r-1, c)+dfs(grid, r, c-1)+dfs(grid, r+1, c)+dfs(grid, r, c+1);
    }

    private boolean connected(int[][] grid, int r, int c) {
        int M = grid.length, N = grid[0].length;
        if (r == 0) {
            return true;
        }

        int[][] directions = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (int[] dir : directions) {
            int dr = r+dir[0], dc = c+dir[1];
            if (dr >= 0 && dr < M && dc >= 0 && dc < N && grid[dr][dc] == 2) {
                return true;
            }
        }
        return false;
    }
}
