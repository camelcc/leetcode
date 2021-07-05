import java.util.PriorityQueue;

public class S1921EliminateMaximumNumberMonsters {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int res = 0, time = 0;
        PriorityQueue<Double> monsters = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            monsters.offer(1.0*dist[i]/speed[i]);
        }
        while (!monsters.isEmpty()) {
            double m = monsters.poll();
            if (m <= time) {
                return res;
            }
            res++;
            time++;
        }
        return res;
    }
}
