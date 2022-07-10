import java.util.TreeMap;

public class S2336SmallestNumberInfiniteSet {
    public static class SmallestInfiniteSet {
        TreeMap<Integer, Integer> map;

        public SmallestInfiniteSet() {
            map = new TreeMap<>();
            map.put(1, Integer.MAX_VALUE);
        }

        public int popSmallest() {
            int res = map.firstKey();
            int right = map.remove(res);
            if (right > res) {
                map.put(res+1, right);
            }
            return res;
        }

        public void addBack(int num) {
            Integer k = map.floorKey(num);
            if (k != null && k <= num && map.get(k) >= num) {
                return;
            }
            map.put(num, num);
        }
    }
}
