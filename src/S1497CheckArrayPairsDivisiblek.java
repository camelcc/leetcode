import java.util.HashMap;
import java.util.HashSet;

public class S1497CheckArrayPairsDivisiblek {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int a : arr) {
            int r = a%k;
            if (res.containsKey(-r)) {
                int c = res.get(-r);
                if (c == 1) {
                    res.remove(-r);
                } else {
                    res.put(-r, c-1);
                }
            } else {
                int o = (r <= 0 ? -k-r : k-r);
                if (res.containsKey(o)) {
                    int c = res.get(o);
                    if (c == 1) {
                        res.remove(o);
                    } else {
                        res.put(o, c-1);
                    }
                } else {
                    res.put(r, res.getOrDefault(r, 0)+1);
                }
            }
        }
        return res.isEmpty();
    }
}
