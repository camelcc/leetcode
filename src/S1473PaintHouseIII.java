public class S1473PaintHouseIII {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int res = -1;
        Integer[][][] dp = new Integer[m][target+1][n];
        for (int c = 0; c < n; c++) {
            int r = min(houses, cost, m, n, 0, c, target, dp);
            if (r != -1) {
                if (res == -1) {
                    res = r;
                } else {
                    res = Math.min(res, r);
                }
            }
        }
        return res;
    }

    private int min(int[] houses, int[][] cost, int m, int n, int h, int c, int t, Integer[][][] dp) {
        if (t <= 0) {
            return -1;
        }
        if (dp[h][t][c] != null) {
            return dp[h][t][c];
        }

        int res = -1;
        if (h == m-1) {
            if (t == 1) {
                if (houses[h] == 0) { // not paint
                    res = cost[h][c];
                } else if (houses[h]-1 == c) { // same color
                    res = 0;
                }
            }
            dp[h][t][c] = res;
            return res;
        }
        if (m-h < t) {
            dp[h][t][c] = res;
            return res;
        }

        // not last house, enough house for target
        if (houses[h] != 0) {
            if (houses[h]-1 == c) {
                for (int nc = 0; nc < n; nc++) {
                    int r = min(houses, cost, m, n, h+1, nc, nc == c ? t : t-1, dp);
                    if (r != -1) {
                        if (res == -1) {
                            res = r;
                        } else {
                            res = Math.min(res, r);
                        }
                    }
                }
            }
            dp[h][t][c] = res;
            return res;
        }

        // not last house, enough houses for target, not paint yet
        for (int nc = 0; nc < n; nc++) {
            int r = min(houses, cost, m, n, h+1, nc, nc == c ? t : t-1, dp);
            if (r != -1) {
                if (res == -1) {
                    res = r + cost[h][c];
                } else {
                    res = Math.min(res, r + cost[h][c]);
                }
            }
        }
        dp[h][t][c] = res;
        return res;
    }
}
