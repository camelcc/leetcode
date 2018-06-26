public class S0059SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int direction = 0; // 0 - right, 1 - down, 2 - left, 3 - up

        int row = 0, column = -1;
        for (int i = 1; i <= n*n; i++) {
            if (direction == 0) { // right
                column++;
                if (column == n-1 || res[row][column+1] != 0) {
                    direction = 1; // down
                }
            } else if (direction == 1) { // down
                row++;
                if (row == n-1 || res[row+1][column] != 0) {
                    direction = 2; // left
                }
            } else if (direction == 2) { // left
                column--;
                if (column == 0 || res[row][column-1] != 0) {
                    direction = 3; // up
                }
            } else if (direction == 3) { // up
                row--;
                if (row == 0 || res[row-1][column] != 0) {
                    direction = 0;
                }
            }

            res[row][column] = i;
        }
        return res;
    }
}
