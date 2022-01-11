public class S2133CheckEveryRowColumnContainsAllNumbers {
    public boolean checkValid(int[][] matrix) {
        int N = matrix.length;
        int[][] row = new int[N][N+1];
        int[][] column = new int[N][N+1];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int v = matrix[r][c];
                if (v <= 0 || v > N) {
                    return false;
                }
                if (row[r][v] != 0) {
                    return false;
                }
                row[r][v] = 1;
                if (column[c][v] != 0) {
                    return false;
                }
                column[c][v] = 1;
            }
        }
        return true;
    }
}
