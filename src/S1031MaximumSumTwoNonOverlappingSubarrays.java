public class S1031MaximumSumTwoNonOverlappingSubarrays {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int res = 0;
        int[][] max = new int[A.length+1][2];
        int[] sum = new int[A.length+1];
        for (int i = A.length-1; i >= 0; i--) {
            sum[i] = sum[i+1]+A[i];
            if (A.length-i >= L) {
                max[i][0] = Math.max(max[i+1][0], sum[i]-sum[i+L]);
            }
            if (A.length-i >= M) {
                max[i][1] = Math.max(max[i+1][1], sum[i]-sum[i+M]);
            }
            if (A.length-i >= (L+M)) {
                res = Math.max(res,
                        Math.max(sum[i]-sum[i+L]+max[i+L][1],
                                sum[i]-sum[i+M]+max[i+M][0]));
            }
        }
        return res;
    }
}
