public class S1901FindPeakElementII {
    public int[] findPeakGrid(int[][] mat) {
        int M = mat.length, N = mat[0].length;
        int t = 0, b = mat.length;
        while (t < b) {
            int mid = t+(b-t)/2;
            int max = 0, c = 0;
            for (int i = 0; i < N; i++) {
                if (mat[mid][i] > max) {
                    max = mat[mid][i];
                    c = i;
                }
            }
            if (mid > 0 && mat[mid-1][c] > max) {
                b = mid;
            } else if (mid < M-1 && mat[mid+1][c] > max) {
                t = mid+1;
            } else {
                return new int[]{mid, c};
            }
        }
        return null;
    }
}
