public class S0879ProfitableSchemes {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int MOD = (int)Math.pow(10, 9) + 7;
        int[][] dp = new int[P+1][G+1];
        dp[0][0] = 1;
        for (int i = 0; i < group.length; i++) {
            int gi = group[i], pi = profit[i];

            for (int p = P; p >= 0; p--) {
                for (int g = G-gi; g >= 0; g--) {
                    int cp = Math.min(P, p+pi);
                    int cg = g+gi;
                    dp[cp][cg] = (dp[cp][cg]+dp[p][g])%MOD;
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= G; i++) {
            res = (int)(((long)res + dp[P][i])%MOD);
        }
        return res;
    }
}
