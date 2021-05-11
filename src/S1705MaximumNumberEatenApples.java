import java.util.Comparator;
import java.util.PriorityQueue;

public class S1705MaximumNumberEatenApples {
    public int eatenApples(int[] apples, int[] days) {
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < apples.length; i++) {
            if (apples[i] > 0) {
                pq.offer(new int[]{i+days[i], apples[i]});
            }
            while (!pq.isEmpty()) {
                int[] t = pq.poll();
                if (t[0] <= i) {
                    continue;
                }
                t[1]--;
                res++;
                if (t[1] > 0) {
                    pq.offer(t);
                }
                break;
            }
        }
        int d = apples.length;
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            if (t[0] <= d) {
                continue;
            }
            t[1]--;
            res++;
            if (t[1] > 0) {
                pq.offer(t);
            }
            d++;
        }
        return res;
    }
}
