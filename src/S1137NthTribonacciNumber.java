public class S1137NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }
        int t0 = 0, t1 = 1, t2 = 1, i = 2;
        while (i < n) {
            i++;
            int t = t0+t1+t2;
            t0 = t1;
            t1 = t2;
            t2 = t;
        }
        return t2;
    }
}
