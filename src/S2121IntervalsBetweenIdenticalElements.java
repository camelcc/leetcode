import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S2121IntervalsBetweenIdenticalElements {
    public long[] getDistances(int[] arr) {
        HashMap<Integer, List<Integer>> cnt = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            cnt.putIfAbsent(v, new ArrayList<>());
            cnt.get(v).add(i);
        }
        long[] res = new long[arr.length];
        for (List<Integer> c : cnt.values()) {
            if (c.size() == 1) {
                res[c.get(0)] = 0;
                continue;
            }

            long total = 0;
            for (int i = 1; i < c.size(); i++) {
                total += c.get(i)-c.get(0);
            }

            for (int i = 0; i < c.size(); i++) {
                res[c.get(i)] = total;
                if (i == c.size()-1) {
                    break;
                }
                long d = c.get(i+1)-c.get(i);
                total -= d*(c.size()-1-i);
                total += d*(i+1);
            }
        }
        return res;
    }
}
