import java.util.LinkedList;

public class S2258EscapeSpreadingFire {
    public int maximumMinutes(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] != 1) {
                    continue;
                }

                LinkedList<int[]> bfs = new LinkedList();
                bfs.offer(new int[]{r, c, 0});
                spread(grid, bfs);
            }
        }

        int[][] max = new int[M][N];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] < 0) {
                    max[r][c] = -grid[r][c];
                } else if (grid[r][c] == 0) {
                    max[r][c] = Integer.MAX_VALUE-1;
                }
            }
        }
        max[M-1][N-1]++;

        int lo = -1, hi = M*N+1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            boolean valid = run(grid, max, mid);
            if (valid) {
                if (lo == mid) {
                    break;
                }
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return lo == M*N ? 1_000_000_000 : lo;
    }

    private boolean run(int[][] grid, int[][] max, int minutes) {
        int M = grid.length, N = grid[0].length;
        boolean[][] visited = new boolean[M][N];
        LinkedList<int[]> bfs = new LinkedList();
        bfs.offer(new int[]{0, 0, minutes});
        visited[0][0] = true;
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            int r = t[0], c = t[1], m = t[2]+1;
            for (int[] d : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc] || max[nr][nc] <= m) {
                    continue;
                }
                if (nr == M-1 && nc == N-1) {
                    return true;
                }
                visited[nr][nc] = true;
                bfs.offer(new int[]{nr, nc, m});
            }
        }
        return false;
    }


    private void spread(int[][] grid, LinkedList<int[]> bfs) {
        int M = grid.length, N = grid[0].length;
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            int r = t[0], c = t[1], time = t[2]-1;
            for (int[] d : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= M || nc < 0 || nc >= N || (grid[nr][nc] != 0 && grid[nr][nc] > time)) {
                    continue;
                }
                grid[nr][nc] = time;
                bfs.offer(new int[]{nr, nc, time});
            }
        }
    }
}
