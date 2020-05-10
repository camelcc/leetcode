public class S1444NumberWaysCuttingPizza {
    public int ways(String[] pizza, int k) {
        int M = pizza.length, N = pizza[0].length();
        char[][] p = new char[M][N];
        for (int r = 0; r < pizza.length; r++) {
            p[r] = pizza[r].toCharArray();
        }
        Integer[][][] dp = new Integer[M][N][k];
        return dp(M, N, p, dp, 0, 0, k-1);
    }

    private int dp(int M, int N, char[][] pizza, Integer[][][] dp, int sr, int sc, int cuts) {
        if (dp[sr][sc][cuts] != null) {
            return dp[sr][sc][cuts];
        }
        boolean[] cutV = new boolean[N];
        boolean[] cutH = new boolean[M];
        for (int r = sr; r < M; r++) {
            boolean have = false;
            for (int c = sc; c < N; c++) {
                if (pizza[r][c] == 'A') {
                    have = true;
                    break;
                }
            }
            cutH[r] = have;
        }
        for (int c = sc; c < N; c++) {
            boolean have = false;
            for (int r = sr; r < M; r++) {
                if (pizza[r][c] == 'A') {
                    have = true;
                    break;
                }
            }
            cutV[c] = have;
        }
        if (cuts == 0) {
            for (int r = sr; r < M; r++) {
                if (cutH[r]) {
                    dp[sr][sc][cuts] = 1;
                    return 1;
                }
            }
            dp[sr][sc][cuts] = 0;
            return 0;
        }

        long res = 0;
        int MOD = (int)(Math.pow(10, 9)+7);
        // cut vertical
        boolean havePrev = false;
        for (int c = sc; c < N-1; c++) {
            if (cutV[c]) {
                havePrev = true;
            }
            if (!havePrev) {
                continue;
            }
            int remains = dp(M, N, pizza, dp, sr, c+1, cuts-1);
            if (remains > 0) {
                res += remains;
                res = res%MOD;
            } else {
                break;
            }
        }
        // cut horizontal
        havePrev = false;
        for (int r = sr; r < M-1; r++) {
            if (cutH[r]) {
                havePrev = true;
            }
            if (!havePrev) {
                continue;
            }
            int remains = dp(M, N, pizza, dp, r+1, sc, cuts-1);
            if (remains > 0) {
                res += remains;
                res = res%MOD;
            } else {
                break;
            }
        }
        dp[sr][sc][cuts] = (int)res;
        return (int)res;
    }
}
