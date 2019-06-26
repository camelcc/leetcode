public class S0918MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int res = Integer.MIN_VALUE;
        int[] postMax = new int[A.length];
        int prev = 0;
        for (int i = 0; i < A.length; i++) {
            prev = Math.max(A[i], A[i]+prev);
            res = Math.max(res, prev);
        }
        prev = A[A.length-1];
        postMax[A.length-1] = prev;
        for (int i = A.length-2; i >= 0; i--) {
            prev += A[i];
            postMax[i] = Math.max(prev, postMax[i+1]);
        }

        int sum = 0;
        for (int i = 0; i < A.length-1; i++) {
            sum += A[i];
            res = Math.max(res, postMax[i+1]+sum);
        }
        return res;
    }
}
