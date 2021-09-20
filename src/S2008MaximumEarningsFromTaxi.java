import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class S2008MaximumEarningsFromTaxi {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(o -> o[0]));
        TreeMap<Integer, Long> dp = new TreeMap<>();
        dp.put(n, 0L);
        int p = rides.length-1;
        long res = 0;
        while (p >= 0) {
            int v = rides[p][0];
            long m = 0;
            while (p >= 0 && rides[p][0] == v) {
                int earn = rides[p][1]-rides[p][0]+rides[p][2];
                m = Math.max(m, earn+dp.get(dp.ceilingKey(rides[p][1])));
                p--;
            }
            res = Math.max(res, m);
            dp.put(v, res);
        }
        return res;
    }
}
