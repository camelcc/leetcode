import java.util.HashMap;
import java.util.TreeMap;

public class S0981TimeBasedKeyValueStore {
    class TimeMap {
        HashMap<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> v = map.get(key);
            if (v == null || v.floorKey(timestamp) == null) {
                return "";
            }
            return v.floorEntry(timestamp).getValue();
        }
    }
}
