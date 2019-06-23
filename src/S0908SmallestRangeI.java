public class S0908SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        return Math.max(0, max-min-2*K);
    }
}
