import java.util.LinkedList;

public class S0749ContainVirus {
    public int containVirus(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int cnt = 0;
        int infect = 1;

        while (infect > 0) {
            infect = 0;
            int walls = 0;
            int ir = -1, ic = -1;
            boolean[][] visited = new boolean[M][N];
            for (int r = 0; r < M; r++) {
                for (int c = 0; c < N; c++) {
                    if (grid[r][c] == 1 && !visited[r][c]) {
                        int[] t = bfs(grid, visited, r, c);
                        if (t[0] > infect) {
                            infect = t[0];
                            walls = t[1];
                            ir = r;
                            ic = c;
                        }
                    }
                }
            }

            if (infect > 0) {
                cnt += walls;
                grid[ir][ic] = -1;
                block(grid, ir, ic);
                spread(grid, new boolean[M][N]);
            }
        }

        return cnt;
    }

    private int[] bfs(int[][] grid, boolean[][] visited, int r, int c) {
        assert grid[r][c] == 1;
        assert !visited[r][c];
        visited[r][c] = true;
        int M = grid.length, N = grid[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        boolean[][] v = new boolean[M][N];
        v[r][c] = true;
        int infected = 0, walls = 0;
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            for (int[] dir : directions) {
                r = q[0]+dir[0];
                c = q[1]+dir[1];
                if (r < 0 || r >= M || c < 0 || c >= N || grid[r][c] == -1) {
                    continue;
                }
                if (grid[r][c] == 0) {
                    walls++;
                    if (!v[r][c]) {
                        infected++;
                        v[r][c] = true;
                    }
                } else {
                    assert grid[r][c] == 1;
                    if (!v[r][c]) {
                        queue.add(new int[]{r, c});
                        visited[r][c] = true;
                        v[r][c] = true;
                    }
                }
            }
        }
        return new int[] {infected, walls};
    }

    private void block(int[][] grid, int r, int c) {
        assert grid[r][c] == -1;
        int M = grid.length, N = grid[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int wall = info[0], infected = info[1];
        for (int[] dir : directions) {
            int dr = r+dir[0];
            int dc = c+dir[1];
            if (dr < 0 || dr >= M || dc < 0 || dc >= N) {
                continue;
            }
            if (grid[dr][dc] == 1) {
                grid[dr][dc] = -1;
                block(grid, dr, dc);
            }
        }
    }

    private void spread(int[][] grid, boolean[][] visited) {
        int M = grid.length, N = grid[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] != 1 || visited[r][c]) {
                    continue;
                }

                for (int[] dir : directions) {
                    int dr = r + dir[0];
                    int dc = c + dir[1];
                    if (dr < 0 || dr >= M || dc < 0 || dc >= N || visited[dr][dc]) {
                        continue;
                    }
                    if (grid[dr][dc] == 0) {
                        grid[dr][dc] = 1;
                        visited[dr][dc] = true;
                    }
                }
            }
        }
    }
}
