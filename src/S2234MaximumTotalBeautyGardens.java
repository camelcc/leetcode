import java.util.Arrays;

public class S2234MaximumTotalBeautyGardens {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        long[] sum = new long[flowers.length+1];
        for (int i = 0; i < flowers.length; i++) {
            sum[i+1] = sum[i]+flowers[i];
        }
        int fullIndex = binarySearch(flowers, 0, flowers.length, target);
        if (fullIndex == 0) {
            return (long)flowers.length * full;
        }
        long res = (long)(flowers.length-fullIndex)*full + (long)flowers[0] * partial;
        for (int i = fullIndex; i >= 0; i--) {
            long needs = (long)target*(fullIndex-i);
            long exist = sum[fullIndex]-sum[i];
            if (newFlowers < needs-exist) {
                break;
            }
            // full[i, end)
            long bea = full * (long)(flowers.length-i);
            if (i == 0) {
                res = Math.max(res, bea);
                return res;
            }

            long remains = newFlowers-(needs-exist);
            int lo = flowers[0], hi = target;

            while (lo < hi) {
                int mid = lo + (hi-lo)/2;
                int p = binarySearch(flowers, 0, i, mid);
                long gap = (long)mid*p - sum[p];
                if (gap <= remains) {
                    lo = mid+1;
                } else if (gap > remains) {
                    hi = mid;
                }
            }
            lo--;
            bea = bea + (long) lo * partial;

            res = Math.max(res, bea);
        }
        return res;
    }

    private int binarySearch(int[] flowers, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (flowers[mid] < target) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
