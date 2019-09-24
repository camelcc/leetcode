import java.util.Comparator;
import java.util.PriorityQueue;

public class S1201UglyNumberIII {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int lo = 1, hi = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            long ct = cnt(mid, a, b, c);
            if (ct < n) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return hi;
    }


    private long cnt(long v, long a, long b, long c) {
        return v/a + v/b + v/c - v/lcm(a, b) - v/lcm(a, c) - v/lcm(b, c) + v/lcm(a, lcm(b, c));
    }

    private long lcm(long a, long b) {
        return (a*b)/gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
}
