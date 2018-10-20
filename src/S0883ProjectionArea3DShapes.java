public class S0883ProjectionArea3DShapes {
    public int projectionArea(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;
        int[] mxz = new int[M];
        int[] myz = new int[N];
        int xy = 0;

        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (grid[x][y] > 0) {
                    xy++;
                }
                if (grid[x][y] > mxz[x]) {
                    mxz[x] = grid[x][y];
                }
                if (grid[x][y] > myz[y]) {
                    myz[y] = grid[x][y];
                }
            }
        }
        for (int i = 0; i < M; i++) {
            xy += mxz[i];
        }
        for (int i = 0; i < N; i++) {
            xy += myz[i];
        }
        return xy;
    }
}
