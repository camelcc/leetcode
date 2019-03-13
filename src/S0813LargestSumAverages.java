public class S0813LargestSumAverages {
    public double largestSumOfAverages(int[] A, int K) {
        Double[][] dp = new Double[A.length][K+1];
        return sum(A, 0, K, dp);
    }

    private double sum(int[] A, int index, int K, Double[][] dp) {
        if (dp[index][K] != null) {
            return dp[index][K];
        }
        assert A.length - index >= K;
        assert K >= 1;

        double res = 0;
        if (K == 1) {
            res = A[index];
            if (index < A.length-1) {
                res = (res + sum(A, index+1, 1, dp)*(A.length-index-1))/(A.length-index);
            }

            dp[index][1] = res;
            return res;
        }

        int sum = 0;
        for (int end = index; end <= A.length-K; end++) {
            sum += A[end];
            double t = sum*1.0/(end-index+1)+sum(A, end+1, K-1, dp);
            res = Math.max(res, t);
        }
        dp[index][K] = res;
        return res;
    }
}
