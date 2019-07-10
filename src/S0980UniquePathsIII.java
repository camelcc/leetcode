import java.util.LinkedList;
import java.util.Queue;

public class S0980UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int start = -1, end = -1, MASK = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                int p = r*N+c;
                if (grid[r][c] == 0) {
                    MASK |= (0x1 << p);
                } else if (grid[r][c] == 1) {
                    MASK |= (0x1 << p);
                    start = p;
                } else if (grid[r][c] == 2) {
                    MASK |= (0x1 << p);
                    end = p;
                }
            }
        }
        int[][] DIRECTIONS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int res = 0;
        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{start, 0x1<<start});
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            int position = t[0], visited = t[1];
            if (position == end) {
                if (visited == MASK) {
                    res++;
                }
                continue;
            }

            for (int[] d : DIRECTIONS) {
                int r = position/N + d[0];
                int c = position%N + d[1];
                int p = r*N+c;
                if (r < 0 || r >= M || c < 0 || c >= N || grid[r][c] == -1 || ((visited&(0x1<<p)) != 0)) {
                    continue;
                }
                bfs.offer(new int[]{r*N+c, visited|(0x1<<p)});
            }
        }
        return res;
    }
}
