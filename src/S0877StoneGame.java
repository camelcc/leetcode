public class S0877StoneGame {
    public boolean stoneGame(int[] piles) {
        int[] sum = new int[piles.length];
        int s = 0;
        for (int i = 0; i < piles.length; i++) {
            s += piles[i];
            sum[i] = s;
        }
        int[][] dp = new int[piles.length][piles.length];
        int alex = stones(piles, sum, 0, piles.length-1, dp);
        return s-alex < alex;
    }

    private int stones(int[] piles, int[] sum, int start, int end, int[][] dp) {
        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        int res = 0;
        if (start == end) {
            res = piles[start];
        } else if (start+1 == end) {
            res = Math.max(piles[start], piles[end]);
        } else {
            int total = sum[end]-sum[start]+piles[start];
            int a = piles[start]+total-piles[start]-stones(piles, sum, start+1, end, dp);
            int b = piles[end]+total-piles[end]-stones(piles, sum, start, end-1, dp);
            res = Math.max(a, b);
        }

        dp[start][end] = res;
        return res;
    }
}
