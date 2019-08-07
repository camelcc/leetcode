public class S0050Pow_x_n {
    public double myPow(double x, int n) {
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1.0/x/myPow(x, Integer.MAX_VALUE);
            }
            return 1.0/myPow(x, 0-n);
        } else if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else {
            int v = n/2;
            return myPow(x*x, v)*myPow(x, n-2*v);
        }
    }
}
