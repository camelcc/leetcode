public class S0832FlippingImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return A;
        }
        int M = A.length;
        int N = A[0].length;
        for (int r = 0; r < M; r++) {
            int lo = 0, hi = N-1;
            while (lo <= hi) {
                int t = A[r][lo];
                A[r][lo] = (A[r][hi] == 1 ? 0 : 1);
                A[r][hi] = (t == 1 ? 0 : 1);
                lo++;
                hi--;
            }
        }
        return A;
    }
}
