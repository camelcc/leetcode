public class S0959RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int N = grid[0].length();
        int[][] visited = new int[N][N];
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 5) {
                    continue;
                }
                if (visited[i][j] == 0) {
                    res++;
                    dfs(grid, visited, i, j, 0);
                }
                if (visited[i][j] == 5) {
                    continue;
                }
                res++;
                dfs(grid, visited, i, j, 0);
            }
        }
        return res;
    }

    private void dfs(String[] grid, int[][] visited, int r, int c, int d) {
        int N = visited.length;
        if (r < 0 || r >= N || c < 0 || c >= N || visited[r][c] == 5) {
            return;
        }
        if ((visited[r][c] == 1 && (d == 1 || d == 4)) ||
                (visited[r][c] == 2 && (d == 2 || d == 3)) ||
                (visited[r][c] == 3 && (d == 1 || d == 3)) ||
                (visited[r][c] == 4 && (d == 2 || d == 4))) {
            return;
        }
        char n = grid[r].charAt(c);
        if (visited[r][c] == 0) {
            if (n == '/') {
                if (d == 0 || d == 1 || d == 3) {
                    visited[r][c] = 3;
                } else if (d == 2 || d == 4) {
                    visited[r][c] = 4;
                }
            } else if (n == '\\') {
                if (d == 0 || d == 1 || d == 4) {
                    visited[r][c] = 1;
                } else if (d == 2 || d == 3) {
                    visited[r][c] = 2;
                }
            } else if (n == ' ') {
                visited[r][c] = 5;
            }
        } else {
            visited[r][c] = 5;
        }

        if (visited[r][c] == 1) {
            dfs(grid, visited, r, c-1, 2);
            dfs(grid, visited, r+1, c, 3);
        } else if (visited[r][c] == 2) {
            dfs(grid, visited, r-1, c, 4);
            dfs(grid, visited, r, c+1, 1);
        } else if (visited[r][c] == 3) {
            dfs(grid, visited, r, c-1, 2);
            dfs(grid, visited, r-1, c, 4);
        } else if (visited[r][c] == 4) {
            dfs(grid, visited, r, c+1, 1);
            dfs(grid, visited, r+1, c, 3);
        } else if (visited[r][c] == 5) {
            dfs(grid, visited, r, c+1, 1);
            dfs(grid, visited, r, c-1, 2);
            dfs(grid, visited, r+1, c, 3);
            dfs(grid, visited, r-1, c, 4);
        }
    }
}
