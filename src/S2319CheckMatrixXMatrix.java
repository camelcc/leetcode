public class S2319CheckMatrixXMatrix {
    public boolean checkXMatrix(int[][] grid) {
        int N = grid.length;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (r == c || c == N-1-r) {
                    if (grid[r][c] == 0) {
                        return false;
                    }
                } else {
                    if (grid[r][c] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
