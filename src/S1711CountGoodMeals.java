import java.util.*;

public class S1711CountGoodMeals {
    public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int d : deliciousness) {
            cnt.put(d, cnt.getOrDefault(d, 0)+1);
        }

        int MOD = 1_000_000_007;
        List<Integer> ks = new ArrayList<>(cnt.keySet());
        Collections.sort(ks);

        long res = 0;
        for (int k : ks) {
            for (int i = 0; i < 22; i++) {
                int v = 0x1<<i;
                if (v-k < 0) {
                    continue;
                }
                if (v-k > k) {
                    break;
                }
                if (v == 2*k) {
                    long t = (long)cnt.get(k)*(cnt.get(k)-1)/2;
                    res = (res+t)%MOD;
                    continue;
                }
                if (cnt.containsKey(v-k)) {
                    long t = (long)cnt.get(v-k) * cnt.get(k);
                    res = (res+t)%MOD;
                }
            }
        }
        return (int)res;
    }
}
