import java.util.ArrayList;
import java.util.List;

public class S2178MaximumSplitPositiveEvenIntegers {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum%2 == 1) {
            return new ArrayList<Long>();
        }
        long sum = finalSum/2;
        long lo = 1, hi = sum;
        while (lo < hi) {
            long mid = lo + (hi-lo)/2;
            long v = mid * (mid+1) / 2;
            if (v < sum) {
                if (lo == mid) {
                    break;
                } else {
                    lo = mid;
                }
            } else if (v == sum) {
                lo = mid;
                break;
            } else {
                hi = mid;
            }
        }
        List<Long> res = new ArrayList<Long>();
        for (long i = 1; i <= lo; i++) {
            res.add(2*i);
        }
        long remains = sum - (lo*(lo+1)/2);
        if (remains > 0) {
            res.set((int)lo-1, res.get((int)lo-1)+2*remains);
        }
        return res;
    }
}
