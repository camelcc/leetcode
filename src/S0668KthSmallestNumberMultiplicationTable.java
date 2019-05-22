public class S0668KthSmallestNumberMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        if (k == 1) {
            return 1;
        }
        int lo = 1, hi = m*n+1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            int c = count(m, n, mid);
            if (c >= k) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return hi;
    }

    private int count(int m, int n, int v) {
        int res = 0;
        for (int r = 1; r <= m; r++) {
            res += Math.min(n, v/r);
        }
        return res;
    }
}
