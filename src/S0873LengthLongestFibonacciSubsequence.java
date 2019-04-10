import java.util.Arrays;

public class S0873LengthLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] A) {
        int res = 0;
        int[][] dp = new int[A.length][A.length];
        for (int third = 2; third < A.length; third++) {
            for (int second = third-1; second > 0 && 2*A[second] > A[third]; second--) {
                int first = Arrays.binarySearch(A, 0, second, A[third]-A[second]);
                if (first < 0) {
                    continue;
                }
                int len = dp[second][first] == 0 ? 3 : dp[second][first]+1;
                dp[third][second] = len;
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
