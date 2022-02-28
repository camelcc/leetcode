public class S2187MinimumTimeCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        // (lo, hi]
        long lo = 0, hi = ((long)time[0])*totalTrips;
        while (lo < hi) {
            long mid = lo + (hi-lo)/2;
            long trips = 0;
            for (int t : time) {
                trips += (mid/t);
            }
            if (trips < totalTrips) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return hi;
    }
}
