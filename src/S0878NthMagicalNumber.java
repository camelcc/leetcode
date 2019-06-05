public class S0878NthMagicalNumber {
    public int nthMagicalNumber(int N, int A, int B) {
        int MOD = (int)Math.pow(10, 9)+7;
        long lcm = lcm(A, B);

        long lo = Math.min(A, B);
        long hi = Math.min(A, B)*(long)N;
        while (lo < hi) {
            long mid = lo + (hi-lo)/2;
            long cnt = mid/A + mid/B - mid/lcm;
            if (cnt < N) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return (int)(lo%MOD);
    }

    private long lcm(int a, int b) {
        return (long)a*b/gcd(a,b);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
