public class S1504CountSubmatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int M = mat.length, N = mat[0].length;
        int[][] len = new int[M][N];

        int res = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (mat[r][c] == 0) {
                    len[r][c] = 0;
                    continue;
                }
                len[r][c] = (c == 0 ? 1 : 1+len[r][c-1]);
                int l = len[r][c];
                for (int y = r; y >= 0; y--) {
                    l = Math.min(l, len[y][c]);
                    res += l;
                }
            }
        }

        return res;
    }
}
