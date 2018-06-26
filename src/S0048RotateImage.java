public class S0048RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length == 1) {
            return;
        }

        int n = matrix.length-1;

        for (int i = 0, w = matrix.length-1; i < matrix.length/2; i++, w--) {
            for (int j = i; j < w; j++) {
                rotate(matrix, n, i, j);
            }
        }
    }

    private void rotate(int[][] matrix, int N, int row, int column) {
        int t = 0, tmp = 0;
        int topLeft = matrix[row][column];

        // (0, 0) -> (0, n-1)
        int topRightRow = column;
        int topRightColumn = N - row;
        t = matrix[topRightRow][topRightColumn];
        matrix[topRightRow][topRightColumn] = topLeft;

        // (0, n-1) -> (n-1, n-1)
        int bottomRightRow = N-row;
        int bottomRightColumn = N-column;
        tmp = matrix[bottomRightRow][bottomRightColumn];
        matrix[bottomRightRow][bottomRightColumn] = t;

        // (n-1, n-1) -> (n-1, 0)
        int bottomLeftRow = N-column;
        int bottomLeftColumn = row;
        t = matrix[bottomLeftRow][bottomLeftColumn];
        matrix[bottomLeftRow][bottomLeftColumn] = tmp;

        // (n-1, 0) -> (0, 0)
        matrix[row][column] = t;
    }
}
