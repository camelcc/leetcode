import java.util.LinkedList;

public class S1254NumberClosedIslands {
    public int closedIsland(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        LinkedList<int[]> bfs = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (grid[0][i] == 0) {
                bfs.offer(new int[]{0, i});
            }
            if (grid[M-1][i] == 0) {
                bfs.offer(new int[]{M-1, i});
            }
        }
        for (int i = 0; i < M; i++) {
            if (grid[i][0] == 0) {
                bfs.offer(new int[]{i, 0});
            }
            if (grid[i][N-1] == 0) {
                bfs.offer(new int[]{i, N-1});
            }
        }
        bfs(M, N, grid, bfs);

        int res = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] != 0) {
                    continue;
                }

                res++;
                bfs.offer(new int[]{r, c});
                bfs(M, N, grid, bfs);
            }
        }
        return res;
    }

    private void bfs(int M, int N, int[][] grid, LinkedList<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            int r = t[0], c = t[1];
            if (grid[r][c] == 1) {
                continue;
            }
            // grid[r][c] == 0 island
            grid[r][c] = 1; // water
            for (int[] dir : new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}}) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= M || nc < 0 || nc >= N || grid[nr][nc] == 1) {
                    continue;
                }
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
