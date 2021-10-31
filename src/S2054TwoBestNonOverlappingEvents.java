import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class S2054TwoBestNonOverlappingEvents {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int res = 0;
        for (int[] event : events) {
            int start = event[0], end = event[1], value = event[2];
            int max = 0;
            if (!map.isEmpty() && map.firstKey() < start) {
                int k = map.firstKey();
                while (!map.isEmpty() && map.firstKey() < start) {
                    k = map.firstKey();
                    max = Math.max(max, map.remove(map.firstKey()));
                }
                map.put(k, max);
            }
            res = Math.max(res, max+value);
            map.put(end, Math.max(max, Math.max(map.getOrDefault(end, 0), value)));
        }
        return res;
    }
}
