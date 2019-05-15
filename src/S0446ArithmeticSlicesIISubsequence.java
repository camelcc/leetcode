import java.util.Arrays;

public class S0446ArithmeticSlicesIISubsequence {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int N = A.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        int res = 0;
        for (int first = 0; first < N; first++) {
            for (int second = first+1; second < N; second++) {
                res += slices(A, first, second, dp);
            }
        }
        return res;
    }

    private int slices(int[] A, int first, int second, int[][] dp) {
        if (dp[second][first] != -1) {
            return dp[second][first];
        }

        int res = 0;
        long diff = (long)A[first]-A[second];
        for (int i = second+1; i < A.length; i++) {
            if ((long)A[second]-A[i] != diff) {
                continue;
            }
            res += slices(A, second, i, dp) + 1;
        }
        dp[second][first] = res;
        return res;
    }
}
