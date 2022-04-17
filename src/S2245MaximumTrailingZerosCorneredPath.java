public class S2245MaximumTrailingZerosCorneredPath {
    public int maxTrailingZeros(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[][][] left = new int[M][N][2];
        int[][][] up = new int[M][N][2];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                int[] d = divide(grid[r][c]);
                int l2 = d[0] + (c > 0 ? left[r][c-1][0] : 0);
                int l5 = d[1] + (c > 0 ? left[r][c-1][1] : 0);
                left[r][c] = new int[]{l2, l5};
                int u2 = d[0] + (r > 0 ? up[r-1][c][0] : 0);
                int u5 = d[1] + (r > 0 ? up[r-1][c][1] : 0);
                up[r][c] = new int[]{u2, u5};
            }
        }

        int res = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                int uc2 = r > 0 ? up[r-1][c][0] : 0, uc5 = r > 0 ? up[r-1][c][1] : 0;
                int two = up[r][c][0]-uc2, five = up[r][c][1]-uc5;
                int dc2 = up[M-1][c][0]-up[r][c][0], dc5 = up[M-1][c][1]-up[r][c][1];
                int lc2 = c > 0 ? left[r][c-1][0]: 0, lc5 = c > 0 ? left[r][c-1][1] : 0;
                int rc2 = left[r][N-1][0]-left[r][c][0], rc5 = left[r][N-1][1]-left[r][c][1];
                res = Math.max(res, Math.min(two + uc2 + lc2, five + uc5 + lc5));
                res = Math.max(res, Math.min(two + uc2 + rc2, five + uc5 + rc5));
                res = Math.max(res, Math.min(two + dc2 + lc2, five + dc5 + lc5));
                res = Math.max(res, Math.min(two + dc2 + rc2, five + dc5 + rc5));
            }
        }
        return res;
    }

    private int[] divide(int v) {
        int two = 0, five = 0;
        while (v%2 == 0) {
            two++;
            v = v/2;
        }
        while (v%5 == 0) {
            five++;
            v = v/5;
        }
        return new int[]{two, five};
    }
}
