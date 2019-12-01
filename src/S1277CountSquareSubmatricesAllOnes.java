public class S1277CountSquareSubmatricesAllOnes {
    public int countSquares(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[][][] cnt = new int[M][N][3];
        int res = 0;

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (matrix[r][c] == 0) {
                    continue;
                }

                // H
                if (c > 0) {
                    cnt[r][c][0] = cnt[r][c-1][0]+1;
                } else {
                    cnt[r][c][0] = 1;
                }
                // V
                if (r > 0) {
                    cnt[r][c][1] = cnt[r-1][c][1]+1;
                } else {
                    cnt[r][c][1] = 1;
                }
                // S
                if (r > 0 && c > 0) {
                    cnt[r][c][2] = Math.min(cnt[r-1][c-1][2]+1, Math.min(cnt[r][c][0], cnt[r][c][1]));
                } else {
                    cnt[r][c][2] = 1;
                }
                res += cnt[r][c][2];
            }
        }
        return res;
    }
}
