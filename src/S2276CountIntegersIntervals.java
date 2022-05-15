import java.util.TreeMap;

public class S2276CountIntegersIntervals {
    static class CountIntervals {
        TreeMap<Integer, Integer> map;
        int res = 0;

        public CountIntervals() {
            map = new TreeMap<>();
        }

        public void add(int left, int right) {
            Integer lo = map.floorKey(left);
            if (lo != null && map.get(lo) >= left) {
                if (map.get(lo) >= right) {
                    return;
                }
                // map.get(lo) < right
                res -= map.remove(lo)-left+1;
            } else {
                lo = left;
            }

            res += right-left+1;

            Integer hi = map.ceilingKey(lo);
            while (hi != null && map.get(hi) <= right) {
                res -= map.remove(hi)-hi+1;
                hi = map.higherKey(hi);
            }
            if (hi == null || hi > right) {
                map.put(lo, right);
                return;
            }

            // hi <= right && map.get(hi) > right
            res -= right-hi+1;
            hi = map.remove(hi);
            map.put(lo, hi);
        }

        public int count() {
            return res;
        }
    }
}
