import java.util.Arrays;
import java.util.HashMap;

public class S0846HandStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length%W != 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int h : hand) {
            map.put(h, map.getOrDefault(h, 0)+1);
        }
        Integer[] keys = map.keySet().toArray(new Integer[map.size()]);
        Arrays.sort(keys);
        for (int i = 0; i < keys.length; i++) {
            int h = keys[i];
            if (!map.containsKey(h)) {
                continue;
            }
            int times = map.get(h);

            for (int t = h; t < h+W; t++) {
                if (!map.containsKey(t) || map.get(t) < times) {
                    return false;
                }

                if (map.get(t) == times) {
                    map.remove(t);
                } else {
                    map.put(t, map.get(t)-times);
                }
            }
        }
        return true;
    }
}
