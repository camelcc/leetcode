import java.util.TreeMap;

public class S1808MaximizeNumberNiceDivisors {
    public int maxNiceDivisors(int primeFactors) {
        int cnt = 0;
        if (primeFactors > 5) {
            cnt = (primeFactors-5)/3;
            primeFactors -= 3*cnt;
        }
        while (primeFactors >= 5) {
            cnt++;
            primeFactors -= 3;
        }

        int MOD = 1_000_000_007;
        TreeMap<Integer, Long> dp = new TreeMap<>();
        dp.put(0, 1L);
        dp.put(1, 3L);
        int p = 1;
        long pv = 3;
        while (2*p <= cnt) {
            p = 2*p;
            pv = pv*pv%MOD;
            dp.put(p, pv);
        }

        long res = power(cnt, dp);
        // p == 4, 3, 2, 1, 0
        if (primeFactors > 1) {
            res = (res*primeFactors)%MOD;
        }
        return (int)res;
    }

    private long power(int cnt, TreeMap<Integer, Long> dp) {
        if (dp.containsKey(cnt)) {
            return dp.get(cnt);
        }
        int MOD = 1_000_000_007;
        Integer k = dp.lowerKey(cnt);
        long res = dp.get(k);
        res = res*power(cnt-k, dp)%MOD;
        return res;
    }
}
