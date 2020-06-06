public class S1463CherryPickupII {
    public int cherryPickup(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        Integer[][][] dp = new Integer[M][N][N];
        return pickup(grid, 0, 0, N-1, dp);
    }

    private int pickup(int[][] grid, int r, int c1, int c2, Integer[][][] dp) {
        if (dp[r][c1][c2] != null) {
            return dp[r][c1][c2];
        }

        int M = grid.length, N = grid[0].length;
        int res = (c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2]);
        if (r == M-1) {
            dp[r][c1][c2] = res;
            return res;
        }
        int prev = res;

        if (c1-1 >= 0) {
            if (c2-1 >= 0) {
                res = Math.max(res, prev + pickup(grid, r+1, c1-1, c2-1, dp));
            }
            res = Math.max(res, prev + pickup(grid, r+1, c1-1, c2, dp));
            if (c2+1 < N) {
                res = Math.max(res, prev + pickup(grid, r+1, c1-1, c2+1, dp));
            }
        }
        if (c1+1 < N) {
            if (c2-1 >= 0) {
                res = Math.max(res, prev + pickup(grid, r+1, c1+1, c2-1, dp));
            }
            res = Math.max(res, prev + pickup(grid, r+1, c1+1, c2, dp));
            if (c2+1 < N) {
                res = Math.max(res, prev + pickup(grid, r+1, c1+1, c2+1, dp));
            }
        }
        if (c2-1 >= 0) {
            res = Math.max(res, prev + pickup(grid, r+1, c1, c2-1, dp));
        }
        res = Math.max(res, prev + pickup(grid, r+1, c1, c2, dp));
        if (c2+1 < N) {
            res = Math.max(res, prev + pickup(grid, r+1, c1, c2+1, dp));
        }
        dp[r][c1][c2] = res;
        return res;
    }
}
