import java.util.Comparator;
import java.util.PriorityQueue;

public class S1854MaximumPopulationYear {
    public int maximumPopulation(int[][] logs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int[] log : logs) {
            pq.offer(new int[]{log[0], 1});
            pq.offer(new int[]{log[1], -1});
        }
        int res = 1950, population = 0, cnt = 0;
        for (int i = 1950; i <= 2050; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                cnt += pq.poll()[1];
            }
            if (cnt > population) {
                population = cnt;
                res = i;
            }
        }
        return res;
    }
}
