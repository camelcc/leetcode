import java.util.Comparator;
import java.util.PriorityQueue;

public class S1882ProcessTasksUsingServers {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (servers[o1] != servers[o2]) {
                return servers[o1]-servers[o2];
            }
            return o1-o2;
        });
        for (int i = 0; i < servers.length; i++) {
            pq.offer(i);
        }
        int[] available = new int[servers.length];
        PriorityQueue<Integer> busy = new PriorityQueue<>(Comparator.comparingInt(o -> available[o]));

        int[] res = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            while (!busy.isEmpty() && available[busy.peek()] <= i) {
                pq.offer(busy.poll());
            }
            if (pq.isEmpty()) {
                int t = busy.peek();
                while (!busy.isEmpty() && available[busy.peek()] == available[t]) {
                    pq.offer(busy.poll());
                }
            }

            int j = pq.poll();
            res[i] = j;
            available[j] = Math.max(available[j], i) + tasks[i];
            busy.offer(j);
        }
        return res;
    }
}
