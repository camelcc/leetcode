import java.util.Comparator;
import java.util.PriorityQueue;

public class S1383MaximumPerformanceTeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int)(Math.pow(10, 9)+7);
        PriorityQueue<Integer> people = new PriorityQueue<>(Comparator.comparingInt((Integer i) -> efficiency[i]).reversed());
        for (int i = 0; i < n; i++) {
            people.offer(i);
        }

        long res = 0;
        long sum = 0;
        PriorityQueue<Integer> group = new PriorityQueue<>(Comparator.comparingInt(i -> speed[i]));
        for (int i = 0; i < k; i++) {
            int p = people.poll();
            group.offer(p);
            sum += speed[p];
            res = Math.max(res, sum*efficiency[p]);
        }
        while (!people.isEmpty()) {
            int p = people.poll();
            int r = group.poll();

            sum = sum-speed[r]+speed[p];
            long g = sum*efficiency[p];
            res = Math.max(res, g);

            group.offer(p);
        }
        return (int)(res%MOD);
    }
}
