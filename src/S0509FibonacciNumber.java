public class S0509FibonacciNumber {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        }

        int v2 = 0;
        int n1 = 1;
        int v1 = 1;
        while (n1 != N-1) {
            int t = v2+v1;
            v2 = v1;
            v1 = t;
            n1++;
        }

        return v2+v1;
    }
}
