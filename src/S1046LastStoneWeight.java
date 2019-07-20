import java.util.Comparator;
import java.util.PriorityQueue;

public class S1046LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() >= 2) {
            int x = pq.poll(), y = pq.poll();
            if (x == y) {
                continue;
            }
            pq.offer(Math.max(x, y)-Math.min(x, y));
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
