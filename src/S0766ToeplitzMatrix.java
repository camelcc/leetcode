public class S0766ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return true;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        for (int i = M-2; i > 0; i--) {
            int v = matrix[i][0];
            int r = i;
            int c = 0;
            while (r < M && c < N) {
                if (matrix[r][c] != v) {
                    return false;
                }
                r++;
                c++;
            }
        }
        for (int i = 0; i < N-1; i++) {
            int v = matrix[0][i];
            int r = 0;
            int c = i;
            while (r < M && c < N) {
                if (matrix[r][c] != v) {
                    return false;
                }
                r++;
                c++;
            }
        }
        return true;
    }
}
