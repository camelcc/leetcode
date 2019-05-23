import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class S0699FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer, int[]> map = new TreeMap<>();
        int highest = 0;
        for (int[] position : positions) {
            int start = position[0];
            int len = position[1];

            List<int[]> overlaps = new ArrayList<>();
            int[] prev = null;
            if (map.floorKey(start) != null) {
                prev = map.get(map.floorKey(start));
                if (prev[1] <= start) {
                    prev = null;
                }
            }
            if (prev == null) {
                Integer t = map.containsKey(start) ? start : map.ceilingKey(start);
                if (t != null) {
                    prev = map.get(t);
                }
            }

            int high = 0;
            while (prev != null && prev[0] < start+len) {
                high = Math.max(high, prev[2]);
                overlaps.add(map.remove(prev[0]));
                if (map.ceilingKey(prev[0]) != null) {
                    prev = map.get(map.ceilingKey(prev[0]));
                } else {
                    prev = null;
                }
            }
            if (overlaps.isEmpty()) {
                map.put(start, new int[]{start, start+len, len});
                highest = Math.max(highest, len);
                res.add(highest);
                continue;
            }

            high += len;
            map.put(start, new int[]{start, start+len, high});
            for (int[] overlap : overlaps) {
                if (overlap[0] < start) {
                    map.put(overlap[0], new int[]{overlap[0], start, overlap[2]});
                }
                if (overlap[1] > start+len) {
                    map.put(start+len, new int[]{start+len, overlap[1], overlap[2]});
                }
            }
            highest = Math.max(highest, high);
            res.add(highest);
        }

        return res;
    }
}
