import java.util.Arrays;

public class S2064MinimizedMaximumProductsDistributedAnyStore {
    public int minimizedMaximum(int n, int[] quantities) {
        int lo = 1, hi = quantities[0];
        for (int q : quantities) {
            hi = Math.max(hi, q);
        }
        if (n == quantities.length) {
            return hi;
        }

        while (lo < hi) {
            int mid = lo+(hi-lo)/2;
            int cnt = 0;
            for (int q : quantities) {
                cnt += Math.ceil(1.0*q/mid);
            }
            if (cnt > n) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
