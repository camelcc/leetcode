public class S0357CountNumbersUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int m = Math.min(n, 10);
        if (m == 0) {
            return 1;
        }

        int res = 0;
        for (int i = 1; i <= m; i++) {
            res += counts(i);
        }
        return res;
    }

    private int counts(int n) {
        if (n == 1) {
            return 10;
        }

        int res = 9;
        int remains = 9;
        for (int i = 2; i <= n; i++) {
            res *= remains;
            remains--;
        }
        return res;
    }
}
