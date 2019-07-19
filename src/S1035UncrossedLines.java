public class S1035UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length+1][B.length+1];
        for (int pa = 0; pa < A.length; pa++) {
            for (int pb = 0; pb < B.length; pb++) {
                if (A[pa] == B[pb]) {
                    dp[pa+1][pb+1] = 1 + dp[pa][pb];
                } else {
                    dp[pa+1][pb+1] = Math.max(dp[pa][pb+1], dp[pa+1][pb]);
                }
            }
        }
        return dp[A.length][B.length];
    }
}
