import java.util.LinkedList;

public class S1594MaximumNonNegativeProductMatrix {
    public int maxProductPath(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        Long[][][] minmax = new Long[M][N][];
        LinkedList<long[]> bfs = new LinkedList<>();
        bfs.offer(new long[]{0, 0, grid[0][0]});
        long res = Long.MIN_VALUE;
        while (!bfs.isEmpty()) {
            long[] t = bfs.poll();
            int r = (int)t[0], c = (int)t[1];
            long v = t[2];
            if (r == M-1 && c == N-1) {
                res = Math.max(res, v);
            }
            if (minmax[r][c] == null) {
                minmax[r][c] = new Long[]{v, v};
            } else {
                if (minmax[r][c][0] <= v && v <= minmax[r][c][1]) {
                    continue;
                }
                minmax[r][c][0] = Math.min(minmax[r][c][0], v);
                minmax[r][c][1] = Math.max(minmax[r][c][1], v);
            }
            if (r+1 < M) {
                bfs.offer(new long[]{r+1, c, v * grid[r+1][c]});
            }
            if (c+1 < N) {
                bfs.offer(new long[]{r, c+1, v * grid[r][c+1]});
            }
        }
        int MOD = 1_000_000_007;
        return res < 0 ? -1 : (int)(res%MOD);
    }
}
