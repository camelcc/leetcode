public class S0240Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int M = matrix.length, N = matrix[0].length;
        return search(matrix, 0, N-1, 0, M-1, target);
    }

    private boolean search(int[][] matrix, int startC, int endC, int startR, int endR, int target) {
        if (startC > endC || startR > endR) {
            return false;
        }
        int r = endR, c = endC;
        while (r >= startR && c >= startC && matrix[r][c] > target) {
            r--;
            c--;
        }
        if (r >= startR && c >= startC && matrix[r][c] == target) {
            return true;
        }
        // matrix[r][c] < target
        return search(matrix, c+1, endC, startR, r, target) ||
                search(matrix, startC, c, r+1, endR, target);
    }
}
