public class S1922CountGoodNumbers {
    public int countGoodNumbers(long n) {
        if (n == 0) {
            return 0;
        }
        int MOD = 1_000_000_007;

        long res = 1;
        res = pow20(n/2);
        if (n%2 == 1) {
            res = res*5%MOD;
        }
        return (int)res;
    }

    private long pow20(long cnt) {
        if (cnt == 0) {
            return 1;
        }
        int MOD = 1_000_000_007;
        long res = 20, c = 1;
        while (2*c <= cnt) {
            res = res*res%MOD;
            c = c+c;
        }
        res = res*pow20(cnt-c)%MOD;
        return res;
    }
}
