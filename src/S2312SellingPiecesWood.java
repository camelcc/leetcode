public class S2312SellingPiecesWood {
    public long sellingWood(int m, int n, int[][] prices) {
        int[][] sell = new int[m+1][n+1];
        for (int[] p : prices) {
            int h = p[0], w = p[1];
            for (int sh = h; sh <= m; sh++) {
                for (int sw = w; sw <= n; sw++) {
                    sell[sh][sw] = Math.max(sell[sh][sw], p[2]);
                }
            }
        }

        Long[][] dp = new Long[m+1][n+1];
        return cut(m, n, prices, dp, sell);
    }

    private long cut(int m, int n, int[][] prices, Long[][] dp, int[][] sell) {
        if (dp[m][n] != null) {
            return dp[m][n];
        }

        long res = sell[m][n];

        // cut
        for (int h = 1; h < m; h++) {
            long r = cut(h, n, prices, dp, sell) + cut(m-h, n, prices, dp, sell);
            res = Math.max(res, r);
        }
        for (int w = 1; w < n; w++) {
            long r = cut(m, w, prices, dp, sell) + cut(m, n-w, prices, dp, sell);
            res = Math.max(res, r);
        }
        dp[m][n] = res;
        return res;
    }
}
