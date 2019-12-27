import java.util.TreeMap;

public class S1288RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] inter : intervals) {
            int l = inter[0], r = inter[1];
            if (map.containsKey(l) && map.get(l) >= r) {
                continue;
            }
            if (map.lowerKey(l) != null && map.get(map.lowerKey(l)) >= r) {
                continue;
            }
            map.put(l, r);
            Integer nl = map.higherKey(l);
            while (nl != null && map.get(nl) <= r) {
                map.remove(nl);
                nl = map.higherKey(nl);
            }
        }
        return map.size();
    }
}
