import java.util.*;

public class S1488AvoidFloodTheCity {
    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        List<Integer> dry = new ArrayList<>();
        HashMap<Integer, Integer> full = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                dry.add(i);
            } else {
                res[i] = -1;
                if (full.containsKey(rains[i])) {
                    int day = full.get(rains[i]);
                    int j = Collections.binarySearch(dry, day+1);
                    if (j < 0) {
                        j = -(j+1);
                    }
                    if (j >= dry.size()) {
                        return new int[]{};
                    }

                    res[dry.remove(j)] = rains[i];
                }

                full.put(rains[i], i);
            }
        }
        for (int d : dry) {
            res[d] = 1;
        }
        return res;
    }
}
