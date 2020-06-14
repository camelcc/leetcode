import java.util.Arrays;

public class S1482MinimumNumberDaysMakemBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m*k > bloomDay.length) {
            return -1;
        }
        if (k == 1) {
            Arrays.sort(bloomDay);
            return bloomDay[m-1];
        }
        int min = bloomDay[0], max = bloomDay[0];
        for (int i = 1; i < bloomDay.length; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        int l = min, r = max, res = 0;
        while (l <= r) {
            int mid = l + (r-l)/2;
            int c = -1, i = 0;
            res = 0;
            while (i <= bloomDay.length) {
                if (i == bloomDay.length || bloomDay[i] > mid) { // break day
                    int len = i-1-c;
                    res += len/k;
                    c = i;
                }
                i++;
            }
            if (res < m) {
                l = mid+1;
            } else {
                if (l == mid) {
                    break;
                }
                r = mid;
            }
        }
        return l <= r ? l : -1;
    }
}
