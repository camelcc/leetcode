public class S0441ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (int)(((long)lo + (long)hi)/2);
            long sumMid = sum(mid);
            if ((long)n > sumMid) {
                lo = mid + 1;
            } else if ((long)n == sumMid) {
                return mid;
            } else {
                hi = mid-1;
            }
        }
        if (sum(lo) > (long)n) {
            return lo-1;
        } else {
            return lo;
        }
    }

    private long sum(int n) {
        return (long)((1.0 + n) * n * 0.5);
    }
}
