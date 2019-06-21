public class S0905SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int lo = 0, hi = A.length-1;
        while (lo < hi) {
            while (lo < A.length && A[lo]%2 == 0) {
                lo++;
            }
            while (hi >= 0 && A[hi]%2 == 1) {
                hi--;
            }
            if (lo >= hi) {
                break;
            }
            int t = A[lo];
            A[lo] = A[hi];
            A[hi] = t;
            lo++;
            hi--;
        }
        return A;
    }
}
