import java.util.LinkedList;

public class S1568MinimumNumberDaysDisconnectIsland {
    public int minDays(int[][] grid) {
        int groups = groups(grid);
        if (groups == 0 || groups > 1) {
            return 0;
        }
        // groups = 1
        int M = grid.length, N = grid[0].length;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 0) {
                    continue;
                }
                grid[r][c] = 0;
                if (groups(grid) != 1) {
                    return 1;
                }
                grid[r][c] = 1;
            }
        }
        return 2;
    }

    private int groups(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        boolean[][] visited = new boolean[M][N];
        int res = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 0 || visited[r][c]) {
                    continue;
                }
                res++;
                LinkedList<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{r, c});
                while (!queue.isEmpty()) {
                    int[] t = queue.poll();
                    for (int[] d : new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}}) {
                        int nr = t[0]+d[0], nc = t[1]+d[1];
                        if (nr < 0 || nr >= M || nc < 0 || nc >= N || grid[nr][nc] == 0 || visited[nr][nc]) {
                            continue;
                        }
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return res;
    }
}
