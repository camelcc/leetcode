import java.util.TreeMap;

public class S1094CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> pq = new TreeMap<>();
        for (int[] trip : trips) {
            pq.put(trip[1], pq.getOrDefault(trip[1], 0) + trip[0]);
            pq.put(trip[2], pq.getOrDefault(trip[2], 0) - trip[0]);
        }
        int c = 0;
        for (int k : pq.keySet()) {
            c += pq.get(k);
            if (c > capacity) {
                return false;
            }
        }
        return true;
    }
}
