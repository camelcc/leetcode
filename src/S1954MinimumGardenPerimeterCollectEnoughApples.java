public class S1954MinimumGardenPerimeterCollectEnoughApples {
    public long minimumPerimeter(long neededApples) {
        long lo = 0, hi = 1000000;
        while (lo < hi) {
            long mid = lo + (hi-lo)/2;
            long cnt = 2*mid*(1+mid)*(2*mid+1);
            if (cnt < neededApples) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return 8*hi;
    }
}
