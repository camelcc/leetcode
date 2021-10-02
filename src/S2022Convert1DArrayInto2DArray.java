public class S2022Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m*n != original.length || original.length == 0) {
            return new int[0][0];
        }
        int[][] res = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                res[r][c] = original[r*n+c];
            }
        }
        return res;
    }
}
