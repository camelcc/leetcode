public class S0807MaxIncreaseKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int M = grid.length;
        if (M == 0) {
            return 0;
        }
        int N = grid[0].length;
        if (N == 0) {
            return 0;
        }

        int[] row = new int[M];
        int[] column = new int[N];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                int v = grid[r][c];
                row[r] = Math.max(row[r], v);
                column[c] = Math.max(column[c], v);
            }
        }
        int res = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                res += Math.min(row[r], column[c]) - grid[r][c];
            }
        }
        return res;
    }
}
