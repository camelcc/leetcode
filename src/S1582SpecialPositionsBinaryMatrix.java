public class S1582SpecialPositionsBinaryMatrix {
    public int numSpecial(int[][] mat) {
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0) {
                    continue;
                }
                row[r]++;
                col[c]++;
            }
        }
        int res = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 1) {
                continue;
            }
            for (int j = 0; j < col.length; j++) {
                if (col[j] != 1) {
                    continue;
                }
                if (mat[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
