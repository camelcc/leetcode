public class S2017GridGame {
    public long gridGame(int[][] grid) {
        int N = grid[0].length;
        long[] sursum = new long[N];
        long sum = 0;
        for (int i = N-1; i >= 0; i--) {
            sum += grid[0][i];
            sursum[i] = sum;
        }
        sum = 0;
        long[] presum = new long[N];
        for (int i = 0; i < N; i++) {
            sum += grid[1][i];
            presum[i] = sum;
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            res = Math.min(res, Math.max(i == 0 ? 0 : presum[i-1], i == N-1 ? 0 : sursum[i+1]));
        }
        return res;
    }
}
