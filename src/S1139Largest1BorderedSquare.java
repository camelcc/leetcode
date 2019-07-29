public class S1139Largest1BorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        int M = grid.length, N = grid[0].length, res = 0;
        int[][][] len = new int[M][N][2];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 0) {
                    len[r][c][0] = 0;
                    len[r][c][1] = 0;
                } else {
                    len[r][c][0] = r == 0 ? 1 : len[r-1][c][0]+1;
                    len[r][c][1] = c == 0 ? 1 : len[r][c-1][1]+1;
                    for (int b = Math.min(len[r][c][0], len[r][c][1]); b >= 1 && b*b > res; b--) {
                        if (len[r-b+1][c][1] >= b && len[r][c-b+1][0] >= b) {
                            res = Math.max(res, b*b);
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
