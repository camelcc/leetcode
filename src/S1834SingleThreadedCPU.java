import java.util.Comparator;
import java.util.PriorityQueue;

public class S1834SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Integer> pool = new PriorityQueue<>((o1, o2) -> {
            if (tasks[o1][0] == tasks[o2][0]) {
                return tasks[o1][1]-tasks[o2][1];
            }
            return tasks[o1][0]-tasks[o2][0];
        });
        for (int i = 0; i < tasks.length; i++) {
            pool.offer(i);
        }
        PriorityQueue<Integer> available = new PriorityQueue<>((o1, o2) -> {
            if (tasks[o1][1] == tasks[o2][1]) {
                return o1-o2;
            }
            return tasks[o1][1]-tasks[o2][1];
        });
        int[] res = new int[tasks.length];
        int time = 0, pos = 0;
        while (!pool.isEmpty() || !available.isEmpty()) {
            if (pool.isEmpty()) {
                while (!available.isEmpty()) {
                    res[pos++] = available.poll();
                }
                return res;
            }
            // pool not empty
            if (available.isEmpty()) {
                int t = pool.poll();
                res[pos++] = t;
                time = tasks[t][0]+tasks[t][1];

                while (!pool.isEmpty() && tasks[pool.peek()][0] <= time) {
                    available.offer(pool.poll());
                }
                continue;
            }
            // pool not empty & available not empty
            int t = available.poll();
            res[pos++] = t;
            time += tasks[t][1];
            while (!pool.isEmpty() && tasks[pool.peek()][0] <= time) {
                available.offer(pool.poll());
            }
        }
        return res;
    }
}
