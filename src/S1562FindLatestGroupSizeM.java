import java.util.*;

public class S1562FindLatestGroupSizeM {
    public int findLatestStep(int[] arr, int m) {
        TreeMap<Integer, Integer> segs = new TreeMap<>();
        HashSet<Integer> groups = new HashSet<>();
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            int step = i+1;
            int v = arr[i];
            Integer lower = segs.lowerKey(v);
            Integer higher = segs.higherKey(v);
            if (lower != null && segs.get(lower) == v-1) {
                groups.remove(lower);
                segs.put(lower, v);
                if (higher != null && higher == v+1) {
                    segs.put(lower, segs.get(higher));
                    groups.remove(higher);
                    segs.remove(higher);
                }
                if (segs.get(lower) - lower + 1 == m) {
                    groups.add(lower);
                }
            } else if (higher != null && higher == v+1) {
                segs.put(v, segs.get(higher));
                segs.remove(higher);
                groups.remove(higher);
                if (segs.get(v)-v+1 == m) {
                    groups.add(v);
                }
            } else {
                segs.put(v, v);
                if (m == 1) {
                    groups.add(v);
                }
            }
            if (!groups.isEmpty()) {
                res = step;
            }
        }
        return res;
    }
}
