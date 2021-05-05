public class S1690StoneGameVII {
    public int stoneGameVII(int[] stones) {
        int[] sum = new int[stones.length];
        sum[0] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            sum[i] = sum[i-1]+stones[i];
        }
        int[][] dp = new int[stones.length][stones.length];
        return score(stones, sum, 0, stones.length-1, dp);
    }

    private int score(int[] stones, int[] sum, int i, int j, int[][] dp) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        if (i == j) {
            return 0;
        }
        if (i+1 == j) {
            dp[i][j] = Math.max(stones[i], stones[j]);
            return dp[i][j];
        }
        // i < j
        int total = sum[j]-(i == 0 ? 0 : sum[i-1]);
        int left = total-stones[i]-score(stones, sum, i+1, j, dp);
        int right = total-stones[j]-score(stones, sum, i, j-1, dp);
        dp[i][j] = Math.max(left, right);
        return dp[i][j];
    }
}
