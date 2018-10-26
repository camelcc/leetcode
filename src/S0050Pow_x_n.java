public class S0050Pow_x_n {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        boolean negative = n < 0;
        if (negative) {
            if (n == Integer.MIN_VALUE) {
                return 1.0/myPow(x, Integer.MAX_VALUE)/x;
            }
            return 1.0/myPow(x, -n);
        }
        if (n == 1) {
            return x;
        }

        // n >= 2
        if (n%2 == 0) {
            return myPow(x*x, n/2);
        } else {
            return x * myPow(x*x, n/2);
        }
    }
}
