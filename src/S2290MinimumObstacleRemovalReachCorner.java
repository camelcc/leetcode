import java.util.Comparator;
import java.util.PriorityQueue;

public class S2290MinimumObstacleRemovalReachCorner {
    public int minimumObstacles(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        Integer[][] minimum = new Integer[M][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int r = t[0], c = t[1], s = t[2];
            if (minimum[r][c] != null && minimum[r][c] <= s) {
                minimum[r][c] = s;
            }
            if (r == M-1 && c == N-1) {
                return s;
            }

            int[][] dir = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
            for (int[] d : dir) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= M || nc < 0 || nc >= N) {
                    continue;
                }
                if (grid[nr][nc] == 0) {
                    if (minimum[nr][nc] == null || minimum[nr][nc] > s) {
                        minimum[nr][nc] = s;
                        pq.offer(new int[]{nr, nc, s});
                    }
                } else if (grid[nr][nc] == 1) {
                    if (minimum[nr][nc] == null || minimum[nr][nc] > s+1) {
                        minimum[nr][nc] = s+1;
                        pq.offer(new int[]{nr, nc, s+1});
                    }
                }
            }
        }
        return minimum[M-1][N-1];
    }
}
