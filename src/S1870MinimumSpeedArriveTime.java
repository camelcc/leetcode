import java.util.Arrays;

public class S1870MinimumSpeedArriveTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length-1 >= hour) {
            return -1;
        }
        int[] prev = Arrays.copyOf(dist, dist.length-1);
        Arrays.sort(prev);
        int lo = 1, hi = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            int p = Arrays.binarySearch(prev, mid);
            if (p < 0) {
                p = -(p+1);
            }
            double time = p;
            for (int i = p; i < prev.length; i++) {
                time += Math.ceil(prev[i]*1.0/mid);
            }
            time += dist[dist.length-1]*1.0/mid;
            if (time < hour) {
                hi = mid;
            } else if (time == hour) {
                return mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }
}
