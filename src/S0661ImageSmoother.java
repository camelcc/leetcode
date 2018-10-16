public class S0661ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return new int[M.length][0];
        }

        int m = M.length;
        int n = M[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = M[i][j];
                int count = 1;
                if (j > 0 && i > 0) {
                    v += M[i-1][j-1];
                    count++;
                }
                if (j > 0) {
                    v += M[i][j-1];
                    count++;
                }
                if (i < m-1 && j > 0) {
                    v += M[i+1][j-1];
                    count++;
                }
                if (i > 0) {
                    v += M[i-1][j];
                    count++;
                }
                if (i < m-1) {
                    v += M[i+1][j];
                    count++;
                }
                if (i > 0 && j < n-1) {
                    v += M[i-1][j+1];
                    count++;
                }
                if (j < n-1) {
                    v += M[i][j+1];
                    count++;
                }
                if (i < m-1 && j < n-1) {
                    v += M[i+1][j+1];
                    count++;
                }
                res[i][j] = (int)Math.floor(1.0*v/count);
            }
        }
        return res;
    }
}
