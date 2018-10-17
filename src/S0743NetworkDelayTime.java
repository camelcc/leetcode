import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0743NetworkDelayTime {
    private boolean[] visited = new boolean[0];
    private int[] cost = new int[0];
    private List<Integer> queue = new ArrayList<>();

    public int networkDelayTime(int[][] times, int N, int K) {
        visited = new boolean[N+1];
        cost = new int[N+1];
        visited[0] = true;
        cost[0] = 0;
        cost[K] = 0;

        queue = new ArrayList<>();
        queue.add(K);
        while (!queue.isEmpty()) {
            int q = queue.remove(0);
            bfs(times, q);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                return -1;
            }
            if (max < cost[i]) {
                max = cost[i];
            }
        }
        return max;
    }

    private void bfs(int[][] times, int k) {
        visited[k] = true;
        HashMap<Integer, Integer> adjs = adj(times, k);
        for (int a : adjs.keySet()) {
            if (!visited[a]) {
                visited[a] = true;
                cost[a] = cost[k] + adjs.get(a);
                queue.add(a);
            } else if (cost[k] + adjs.get(a) < cost[a]) {
                cost[a] = cost[k] + adjs.get(a);
                queue.add(a);
            }
        }
    }

    private HashMap<Integer, Integer> adj(int[][] times, int src) {
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            if (times[i][0] == src) {
                res.put(times[i][1], times[i][2]);
            }
        }
        return res;
    }
}
