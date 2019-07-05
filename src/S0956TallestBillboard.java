public class S0956TallestBillboard {
    public int tallestBillboard(int[] rods) {
        int N = rods.length;
        boolean[][] dp = new boolean[N+1][10001];
        int[][] sum = new int[N+1][10001];
        dp[0][5000] = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (j - rods[i] >= 0 && dp[i][j - rods[i]]) {
                    dp[i + 1][j] = true;
                    sum[i + 1][j] = Math.max(sum[i + 1][j], sum[i][j - rods[i]] + rods[i]);
                }
                if (j + rods[i] <= 10000 && dp[i][j + rods[i]]) {
                    dp[i + 1][j] = true;
                    sum[i + 1][j] = Math.max(sum[i + 1][j], sum[i][j + rods[i]]);
                }
                if (dp[i][j]) {
                    dp[i + 1][j] = true;
                    sum[i + 1][j] = Math.max(sum[i + 1][j], sum[i][j]);
                }
            }
        }
        return sum[N][5000];
    }
}
