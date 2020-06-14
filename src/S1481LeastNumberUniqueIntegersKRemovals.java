import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class S1481LeastNumberUniqueIntegersKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int a : arr) {
            cnt.put(a, cnt.getOrDefault(a, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(cnt::get));
        for (int a : cnt.keySet()) {
            pq.offer(a);
        }
        int r = 0;
        while (r < k && !pq.isEmpty()) {
            int c = cnt.get(pq.peek());
            if (r + c > k) {
                break;
            } else {
                pq.poll();
                r += c;
            }
        }
        return pq.size();
    }
}
