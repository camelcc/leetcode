import java.util.LinkedList;
import java.util.Queue;

public class S1034ColoringABorder {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if (grid[r0][c0] == color) {
            return grid;
        }
        int M = grid.length, N = grid[0].length, C = grid[r0][c0];
        int[][] DIRECTIONS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        boolean[][] visited = new boolean[M][N];
        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{r0, c0});
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            int r = t[0], c = t[1];
            visited[r][c] = true;
            if (r == 0 || r == M-1 || c == 0 || c == N-1) {
                grid[r][c] = -1;
            } else {
                boolean internal = true;
                for (int[] dir : DIRECTIONS) {
                    int dr = r+dir[0], dc = c+dir[1];
                    if (grid[dr][dc] != C && grid[dr][dc] != -1) {
                        internal = false;
                        break;
                    }
                }
                if (!internal) {
                    grid[r][c] = -1;
                }
            }

            for (int[] d : DIRECTIONS) {
                int dr = t[0]+d[0], dc = t[1]+d[1];
                if (dr < 0 || dr >= M || dc < 0 || dc >= N || grid[dr][dc] != C || visited[dr][dc]) {
                    continue;
                }
                bfs.offer(new int[]{dr, dc});
            }
        }
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == -1) {
                    grid[r][c] = color;
                }
            }
        }
        return grid;
    }
}
