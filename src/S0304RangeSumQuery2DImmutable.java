public class S0304RangeSumQuery2DImmutable {
    class NumMatrix {
        int[][] sum;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int M = matrix.length, N = matrix[0].length;
            sum = new int[M][N];
            for (int r = 0; r < M; r++) {
                int s = 0;
                for (int c = 0; c < N; c++) {
                    s+= matrix[r][c];
                    if (r == 0) {
                        sum[r][c] = s;
                    } else {
                        sum[r][c] = sum[r-1][c] + s;
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int res = sum[row2][col2];
            if (row1 > 0 && col1 > 0) {
                res += sum[row1-1][col1-1];
            }
            if (row1 > 0) {
                res -= sum[row1-1][col2];
            }
            if (col1 > 0) {
                res -= sum[row2][col1-1];
            }
            return res;
        }
    }
}
