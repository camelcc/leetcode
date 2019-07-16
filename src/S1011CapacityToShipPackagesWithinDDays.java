public class S1011CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int lo = weights[0], hi = 0;
        for (int i = 0; i < weights.length; i++) {
            lo = Math.max(lo, weights[i]);
            hi += weights[i];
        }
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            int days = 1, cur = 0;
            for (int i = 0; i < weights.length; i++) {
                if (cur+weights[i] <= mid) {
                    cur += weights[i];
                } else {
                    days++;
                    cur = weights[i];
                }
            }
            if (days <= D) {
                hi = mid;
            } else { // days > D
                lo = mid+1;
            }
        }
        return lo;
    }
}
