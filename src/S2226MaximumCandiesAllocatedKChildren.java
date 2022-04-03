public class S2226MaximumCandiesAllocatedKChildren {
    public int maximumCandies(int[] candies, long k) {
        int lo = 0, hi = candies[0];
        for (int c : candies) {
            hi = Math.max(hi, c);
        }
        hi++;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (mid == 0) {
                break;
            }
            long piles = 0;
            for (int c : candies) {
                piles += c/mid;
                if (piles >= k) {
                    break;
                }
            }
            if (piles >= k) {
                if (lo == mid) {
                    break;
                }
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
