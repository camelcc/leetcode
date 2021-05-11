import java.util.Arrays;
import java.util.LinkedList;

public class S1706WhereWillBallFall {
    public int[] findBall(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[] res = new int[N];
        Arrays.fill(res, -1);
        LinkedList<int[]> bfs = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            bfs.offer(new int[]{0, i, i});
        }
        while (!bfs.isEmpty()) {
            int[] b = bfs.poll();
            int r = b[0], c = b[1];
            if (r == M) {
                res[b[2]] = c;
                continue;
            }

            if (grid[r][c] == 1) {
                if (c+1 == N || grid[r][c+1] == -1) {
                    continue;
                }
                bfs.offer(new int[]{r+1, c+1, b[2]});
            } else if (grid[r][c] == -1) {
                if (c == 0 || grid[r][c-1] == 1) {
                    continue;
                }
                bfs.offer(new int[]{r+1, c-1, b[2]});
            }
        }
        return res;
    }
}
