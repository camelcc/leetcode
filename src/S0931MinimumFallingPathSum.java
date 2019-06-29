public class S0931MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        int sum = Integer.MAX_VALUE;
        for (int r = 1; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int t = A[r-1][c];
                if (c > 0) {
                    t = Math.min(t, A[r-1][c-1]);
                }
                if (c < N-1) {
                    t = Math.min(t, A[r-1][c+1]);
                }
                A[r][c] += t;
            }
        }
        for (int i = 0; i < N; i++) {
            sum = Math.min(sum, A[N-1][i]);
        }
        return sum;
    }
}
