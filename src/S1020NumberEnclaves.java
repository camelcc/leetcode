import java.util.LinkedList;
import java.util.Queue;

public class S1020NumberEnclaves {
    public int numEnclaves(int[][] A) {
        int M = A.length, N = A[0].length;
        int[][] DIR = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        Queue<int[]> bfs = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            if (A[i][0] == 1) {
                bfs.offer(new int[]{i, 0});
            }
            if (A[i][N-1] == 1) {
                bfs.offer(new int[]{i, N-1});
            }
        }
        for (int i = 1; i < N-1; i++) {
            if (A[0][i] == 1) {
                bfs.offer(new int[]{0, i});
            }
            if (A[M-1][i] == 1) {
                bfs.offer(new int[]{M-1, i});
            }
        }
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            if (A[t[0]][t[1]] == -1) {
                continue;
            }
            A[t[0]][t[1]] = -1;
            for (int[] d : DIR) {
                int r = t[0]+d[0], c = t[1]+d[1];
                if (r < 0 || r >= M || c < 0 || c >= N || A[r][c] == 0) {
                    continue;
                }
                bfs.offer(new int[]{r, c});
            }
        }
        int res = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (A[r][c] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
