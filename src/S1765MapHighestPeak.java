import java.util.LinkedList;

public class S1765MapHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int M = isWater.length, N = isWater[0].length;
        LinkedList<int[]> bfs = new LinkedList<>();
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (isWater[r][c] == 1) {
                    bfs.offer(new int[]{r, c, 0});
                }
            }
        }
        int[][] res = new int[M][N];
        while (!bfs.isEmpty()) {
            LinkedList<int[]> next = new LinkedList<>();
            for (int[] b : bfs) {
                for (int[] dir : new int[][]{{-1 ,0}, {0, -1}, {1, 0}, {0, 1}}) {
                    int nr = b[0]+dir[0], nc = b[1]+dir[1];
                    if (nr < 0 || nr >= M || nc < 0 || nc >= N || isWater[nr][nc] == 1 || (res[nr][nc] != 0 && res[nr][nc] <= b[2]+1)) {
                        continue;
                    }
                    res[nr][nc] = b[2]+1;
                    next.offer(new int[]{nr, nc, b[2]+1});
                }
            }
            bfs = next;
        }
        return res;
    }
}
