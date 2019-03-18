import java.util.Arrays;

public class S0823BinaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        long[] dp = new long[A.length];

        long res = 0;
        for (int i = 0; i < A.length; i++) {
            res += cnt(A, i, dp);
        }
        return (int)(res % ((long)Math.pow(10, 9) + 7));
    }

    private long cnt(int[] A, int index, long[] dp) {
        if (dp[index] != 0) {
            return dp[index];
        }

        int v = A[index];

        long res = 1;
        for (int i = 0; i < index; i++) {
            int left = A[i];
            if (v%left != 0) {
                continue;
            }
            int right = v/left;
            int ri = Arrays.binarySearch(A, 0, index, right);
            if (ri < 0) {
                continue;
            }

            long leftCnt = cnt(A, i, dp);
            long rightCnt = cnt(A, ri, dp);
            res += leftCnt * rightCnt;
        }

        dp[index] = res;
        return res;
    }
}
