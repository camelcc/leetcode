import java.util.TreeMap;

public class S0715RangeModule {
    public static class RangeModule {
        TreeMap<Integer, Integer> map;

        public RangeModule() {
            map = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            if (queryRange(left, right)) {
                return;
            }
            Integer l = null;
            if (map.floorKey(left) != null && map.get(map.floorKey(left)) >= left) {
                l = map.floorKey(left);
            }
            if (l == null) {
                l = map.containsKey(left) ? left : map.ceilingKey(left);
            }
            if (l == null || l > right) {
                map.put(left, right);
                return;
            }

            Integer r = Math.max(right, map.remove(l));
            Integer t = map.ceilingKey(l);
            while (t != null && t <= r) {
                r = Math.max(r, map.remove(t));
                t = map.ceilingKey(t);
            }
            map.put(Math.min(l, left), r);
        }

        public boolean queryRange(int left, int right) {
            if (map.containsKey(left)) {
                return map.get(left) >= right;
            }
            Integer l = map.floorKey(left);
            if (l != null && map.get(l) >= right) {
                return true;
            }
            return false;
        }

        public void removeRange(int left, int right) {
            Integer l = null;
            if (map.floorKey(left) != null && map.get(map.floorKey(left)) > left) {
                l = map.floorKey(left);
            }
            if (l == null) {
                l = map.containsKey(left) ? left : map.ceilingKey(left);
            }
            if (l == null || l >= right) {
                return;
            }

            while (l != null && l < right) {
                int r = map.remove(l);
                if (l < left) {
                    assert r > left;
                    map.put(l, left);
                }
                if (r > right) {
                    map.put(right, r);
                }
                l = map.ceilingKey(r);
            }
        }
    }
}
