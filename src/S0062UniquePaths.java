public class S0062UniquePaths {
    public int uniquePaths(int m, int n) {
        int r = m-1, d = n-1;
        return (int)(c(r, d)/mul(Math.min(r, d)));
    }

    private long c(int m, int n) {
        int c = m+n;
        int min = Math.min(m, n);
        long res = 1;
        while (min > 0) {
            res = res * c;
            c--;
            min--;
        }
        return res;
    }

    private long mul(int n) {
        int res = 1;
        while (n > 1) {
            res = res * n;
            n--;
        }
        return res;
    }
}
