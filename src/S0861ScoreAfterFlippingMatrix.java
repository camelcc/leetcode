public class S0861ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int N = A.length;
        int M = A[0].length;
        for (int r = 0; r < N; r++) {
            if (A[r][0] == 0) {
                for (int c = 0; c < M; c++) {
                    if (A[r][c] == 0) {
                        A[r][c] = 1;
                    } else {
                        A[r][c] = 0;
                    }
                }
            }
        }

        for (int c = 1; c < M; c++) {
            int ones = 0;
            for (int r = 0; r < N; r++) {
                if (A[r][c] == 1) {
                    ones++;
                }
            }
            if (N - ones > ones) {
                for (int r = 0; r < N; r++) {
                    if (A[r][c] == 1) {
                        A[r][c] = 0;
                    } else {
                        A[r][c] = 1;
                    }
                }
            }
        }

        int res = 0;
        for (int r = 0; r < N; r++) {
            int t = 0;
            for (int c = 0; c < M; c++) {
                t = t*2+A[r][c];
            }
            res += t;
        }
        return res;
    }
}
