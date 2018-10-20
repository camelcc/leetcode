public class S0867TransposeMatrix {
    public int[][] transpose(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return A;
        }
        int M = A.length, N = A[0].length;
        int[][] res = new int[N][M];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                res[c][r] = A[r][c];
            }
        }
        return res;
    }
}
