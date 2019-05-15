import java.util.HashMap;
import java.util.LinkedHashSet;

public class S0460LFUCache {
    public static class LFUCache {
        HashMap<Integer, Integer> vals;
        HashMap<Integer, Integer> freq;
        HashMap<Integer, LinkedHashSet<Integer>> groups;
        int min = -1;
        int capacity = 0;


        public LFUCache(int capacity) {
            vals = new HashMap<>();
            freq = new HashMap<>();
            groups = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            int res = vals.getOrDefault(key, -1);
            if (res == -1) {
                return res;
            }

            int cnt = freq.get(key);
            freq.put(key, cnt+1);
            groups.get(cnt).remove(key);
            if (groups.get(cnt).isEmpty()) {
                if (min == cnt) {
                    min++;
                }
                groups.remove(cnt);
            }
            if (!groups.containsKey(cnt+1)) {
                groups.put(cnt+1, new LinkedHashSet<>());
            }
            groups.get(cnt+1).add(key);
            return res;
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }

            if (vals.containsKey(key)) {
                vals.put(key, value);
                get(key);
                return;
            }


            if (vals.size() == capacity) {
                int removeKey = groups.get(min).iterator().next();
                groups.get(min).remove(removeKey);
                freq.remove(removeKey);
                vals.remove(removeKey);
            }

            min = 1;
            vals.put(key, value);
            freq.put(key, 1);
            if (!groups.containsKey(1)) {
                groups.put(1, new LinkedHashSet<>());
            }
            groups.get(1).add(key);
        }
    }
}
