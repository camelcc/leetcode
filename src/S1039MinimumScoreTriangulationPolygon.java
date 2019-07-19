public class S1039MinimumScoreTriangulationPolygon {
    public int minScoreTriangulation(int[] A) {
        return min(A, 0, A.length-1, new int[A.length][A.length]);
    }

    private int min(int[] A, int start, int end, int[][] dp) {
        if (end-start+1 < 3) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int mid = start+1; mid < end; mid++) {
            int r = A[start]*A[mid]*A[end];
            r += min(A, start, mid, dp)+min(A, mid, end, dp);
            res = Math.min(res, r);
        }
        dp[start][end] = res;
        return res;
    }
}
