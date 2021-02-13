import java.util.Arrays;

public class S1552MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1, hi = position[position.length-1]-position[0];
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (valid(position, m, mid)) {
                if (mid == lo) {
                    if (valid(position, m, mid+1)) {
                        return mid+1;
                    } else {
                        return mid;
                    }
                }
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private boolean valid(int[] position, int m, int d) {
        int c = position[0];
        m--;
        int i = 1;
        while (m > 0 && i < position.length) {
            while (i < position.length) {
                if (position[i] - c < d) {
                    i++;
                } else {
                    // >= d
                    c = position[i];
                    m--;
                    i++;
                    break;
                }
            }
        }
        return m == 0;
    }
}
