public class S0977SquaresSortedArray {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int lo = 0, hi = A.length-1, p = A.length-1;
        while (lo <= hi) {
            if (Math.abs(A[lo]) >= Math.abs(A[hi])) {
                res[p--] = A[lo]*A[lo];
                lo++;
            } else {
                res[p--] = A[hi]*A[hi];
                hi--;
            }
        }
        return res;
    }
}
