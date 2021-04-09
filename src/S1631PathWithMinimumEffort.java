import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class S1631PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int M = heights.length, N = heights[0].length;

        int[][] diff = new int[M][N];
        for (int r = 0; r < M; r++) {
            Arrays.fill(diff[r], Integer.MAX_VALUE);
        }
        diff[0][0] = 0;
        boolean[][] visited = new boolean[M][N];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.offer(new int[]{0, 0, 0});
        while (!visited[M-1][N-1]) {
            int[] t = pq.poll();
            int r = t[0], c = t[1], d = t[2];
            visited[r][c] = true;
            for (int[] dir : new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}}) {
                int nr = r+dir[0], nc = c+dir[1];
                if (nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc]) {
                    continue;
                }
                int nd = Math.max(d, Math.abs(heights[nr][nc]-heights[r][c]));
                diff[nr][nc] = Math.min(diff[nr][nc], nd);
                pq.offer(new int[]{nr, nc, diff[nr][nc]});
            }
        }
        return diff[M-1][N-1];
    }
}
