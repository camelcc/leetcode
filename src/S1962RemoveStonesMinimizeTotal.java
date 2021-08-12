import java.util.Comparator;
import java.util.PriorityQueue;

public class S1962RemoveStonesMinimizeTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int p : piles) {
            pq.offer(p);
        }
        while (k > 0) {
            int t = pq.poll();
            int r = (int)Math.floor(t/2);
            pq.offer(t-r);
            if (r == 0) {
                break;
            }
            k--;
        }
        int res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }
}
