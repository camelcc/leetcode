public class S0069SqrtX {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int lo = 1, hi = x;
        while (lo < hi) {
            int mid = (lo + hi)/2;
            int div = x / mid;
            if (div == mid) {
                return mid;
            } else if (div > mid) {
                if (lo == mid) {
                    return lo;
                }

                lo = mid;
            } else { // v > x
                hi = mid;
            }
        }
        return lo;
    }
}
