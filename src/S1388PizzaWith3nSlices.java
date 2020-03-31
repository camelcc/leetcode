public class S1388PizzaWith3nSlices {
    public int maxSizeSlices(int[] slices) {
        int M = slices.length;
        int N = M/3;
        return Math.max(findMax(slices, 0, M-2, N), findMax(slices, 1, M-1, N));
    }

    private int findMax(int[] slices, int lo, int hi, int N) {
        int[][] dp = new int[hi-lo+1][N+1];
        for (int i = 0; i <= hi-lo; i++) {
            for (int k = 1; k <= N; k++) {
                int pick = (i >= 2) ? dp[i-2][k-1] : 0;
                int skip = (i >= 1) ? dp[i-1][k] : 0;
                dp[i][k] = Math.max(skip, pick + slices[i+lo]);
            }
        }
        return dp[hi-lo][N];
    }
}
