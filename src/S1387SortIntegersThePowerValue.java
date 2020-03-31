import java.util.Arrays;
import java.util.HashMap;

public class S1387SortIntegersThePowerValue {
    public int getKth(int lo, int hi, int k) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 0);
        Integer[] data = new Integer[hi-lo+1];
        for (int i = 0; i < data.length; i++) {
            data[i] = lo+i;
        }
        Arrays.sort(data, (Integer o1, Integer o2) -> {
            int p1 = power(o1, dp);
            int p2 = power(o2, dp);
            if (p1 != p2) {
                return p1-p2;
            } else {
                return o1-o2;
            }
        });
        return data[k-1];
    }

    private int power(int v, HashMap<Integer, Integer> dp) {
        if (dp.containsKey(v)) {
            return dp.get(v);
        }
        int res = 0;
        if (v%2 == 0) {
            res = 1 + power(v/2, dp);
        } else {
            res = 1 + power(3*v+1, dp);
        }
        dp.put(v, res);
        return res;
    }
}
