public class S0978LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        int[] hi = new int[A.length];
        int[] lo = new int[A.length];
        int res = 1;
        hi[A.length-1] = 1;
        lo[A.length-1] = 1;
        for (int i = A.length-2; i >= 0; i--) {
            if (A[i] < A[i+1]) {
                hi[i] = 1;
                lo[i] = hi[i+1]+1;
            } else if (A[i] == A[i+1]) {
                hi[i] = 1;
                lo[i] = 1;
            } else { // A[i] > A[i+1]
                hi[i] = lo[i+1]+1;
                lo[i] = 1;
            }
            res = Math.max(res, Math.max(hi[i], lo[i]));
        }
        return res;
    }
}
