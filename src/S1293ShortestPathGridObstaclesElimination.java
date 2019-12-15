import java.util.Arrays;
import java.util.LinkedList;

public class S1293ShortestPathGridObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int res = Integer.MAX_VALUE;

        int M = grid.length, N = grid[0].length;
        int[][][] visited = new int[M][N][k+1];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                Arrays.fill(visited[r][c], Integer.MAX_VALUE);
            }
        }

        LinkedList<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{0, 0, 0, 0});
        while (!bfs.isEmpty()) {
            int[] b = bfs.poll();
            int r = b[0], c = b[1], o = b[2], s = b[3];
            boolean isNew = true;
            for (int ob = 0; ob <= o; ob++) {
                if (visited[r][c][ob] <= s) {
                    isNew = false;
                    break;
                }
            }
            if (!isNew) {
                continue;
            }
            visited[r][c][o] = s;
            if (r == M-1 && c == N-1) {
                res = Math.min(res, s);
                continue;
            }

            for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                int dr = r+dir[0], dc = c+dir[1];
                if (dr < 0 || dr >= M || dc < 0 || dc >= N) {
                    continue;
                }
                if (grid[dr][dc] == 1 && o == k) {
                    continue;
                }
                int dob = o+grid[dr][dc], ds = s+1;

                isNew = true;
                for (int ob = 0; ob <= dob; ob++) {
                    if (visited[dr][dc][ob] <= ds) {
                        isNew = false;
                        break;
                    }
                }
                if (isNew) {
                    bfs.offer(new int[]{dr, dc, dob, ds});
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
