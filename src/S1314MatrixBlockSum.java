public class S1314MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int M = mat.length, N = mat[0].length;
        int[][] sum = new int[M][N];
        for (int r = 0; r < M; r++) {
            int s = 0;
            for (int c = 0; c < N; c++) {
                s += mat[r][c];
                sum[r][c] = (r == 0 ? 0 : sum[r-1][c]) + s;
            }
        }
        int[][] res = new int[M][N];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                int tl = 0;
                if (r-K-1 >= 0 && c-K-1 >= 0) {
                    tl = sum[r-K-1][c-K-1];
                }
                int tr = 0;
                if (r-K-1 >= 0) {
                    tr = sum[r-K-1][c+K >= N ? N-1 : c+K];
                }
                int lb = 0;
                if (c-K-1 >= 0) {
                    lb = sum[r+K >= M ? M-1 : r+K][c-K-1];
                }
                int br = sum[r+K >= M ? M-1 : r+K][c+K >= N ? N-1 : c+K];
                res[r][c] = br-(tr+lb-tl);
            }
        }
        return res;
    }
}
