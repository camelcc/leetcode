public class S0073SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int N = matrix.length;
        int M = matrix[0].length;
        // first column
        int firstColumn = matrix[0][0];
        for (int i = 0; i < N; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = 0;
                break;
            }
        }

        // row
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    break;
                }
            }
        }

        // column
        for (int c = 1; c < M; c++) {
            for (int r = 0; r < N; r++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    break;
                }
            }
        }

        // column
        for (int i = 1; i < M; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < N; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // row
        for (int i = 0; i < N; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // first column
        if (firstColumn == 0) {
            for (int i = 0; i < N; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
