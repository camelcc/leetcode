public class S1572MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int M = mat.length;
        int res = 0;
        for (int i = 0; i < M; i++) {
            res += mat[i][i];
            res += mat[i][M-1-i];
        }
        if (M%2 == 1) {
            int i = M/2;
            res -= mat[i][i];
        }
        return res;
    }
}
