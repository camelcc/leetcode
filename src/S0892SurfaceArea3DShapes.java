public class S0892SurfaceArea3DShapes {
    public int surfaceArea(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int M = grid.length;
        int N = grid[0].length;
        int cnt = 0;
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (grid[x][y] > 0) {
                    cnt += (grid[x][y] * 4 + 2);
                }
                if (x > 0) {
                    cnt -= Math.min(grid[x][y], grid[x - 1][y]);
                }
                if (x < M-1) {
                    cnt -= Math.min(grid[x][y], grid[x+1][y]);
                }
                if (y > 0) {
                    cnt -= Math.min(grid[x][y], grid[x][y - 1]);
                }
                if (y < N-1) {
                    cnt -= Math.min(grid[x][y], grid[x][y+1]);
                }
            }
        }
        return cnt;
    }
}
