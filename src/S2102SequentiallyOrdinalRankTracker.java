import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class S2102SequentiallyOrdinalRankTracker {
    public static class SORTracker {
        int time = 0;
        HashMap<String, Integer> map = new HashMap<>();
        List<String> sorted = new ArrayList<>();


        public SORTracker() {
        }

        public void add(String name, int score) {
            map.put(name, score);
            int i = Collections.binarySearch(sorted, name, ((o1, o2) -> {
                int v1 = map.get(o1);
                int v2 = map.get(o2);
                if (v1 != v2) {
                    return v2-v1;
                }
                return o1.compareTo(o2);
            }));
            i = -(i+1);
            sorted.add(i, name);
        }

        public String get() {
            return sorted.get(time++);
        }
    }
}
