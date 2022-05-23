import java.util.PriorityQueue;

public class S2279MaximumBagsWithFullCapacityRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] == rocks[i]) {
                res++;
                continue;
            }

            pq.offer(capacity[i]-rocks[i]);
        }
        while (additionalRocks > 0 && !pq.isEmpty()) {
            int gap = pq.poll();
            if (additionalRocks < gap) {
                break;
            }

            if (additionalRocks >= gap) {
                additionalRocks -= gap;
                res++;
            }
        }
        return res;
    }
}
