import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class S2203MinimumWeightedSubgraphWithRequiredPaths {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        HashMap<Integer, Integer>[] graph = new HashMap[n];
        HashMap<Integer, Integer>[] reverse = new HashMap[n];
        for (int[] edge : edges) {
            int f = edge[0], t = edge[1], w = edge[2];
            if (graph[f] == null) {
                graph[f] = new HashMap<>();
            }
            if (reverse[t] == null) {
                reverse[t] = new HashMap<>();
            }
            if (!graph[f].containsKey(t) || graph[f].get(t) > w) {
                graph[f].put(t, w);
            }
            if (!reverse[t].containsKey(f) || reverse[t].get(f) > w) {
                reverse[t].put(f, w);
            }
        }

        long[] dist1 = new long[n];
        long[] dist2 = new long[n];
        long[] distR = new long[n];
        distance(n, graph, src1, dist1);
        distance(n, graph, src2, dist2);
        distance(n, reverse, dest, distR);
        if (dist1[dest] == Long.MAX_VALUE) {
            return -1;
        }
        if (dist2[dest] == Long.MAX_VALUE) {
            return -1;
        }
        long res = dist1[dest] + dist2[dest];
        for (int i = 0; i < n; i++) {
            if (dist1[i] == Long.MAX_VALUE || dist2[i] == Long.MAX_VALUE || distR[i] == Long.MAX_VALUE) {
                continue;
            }
            res = Math.min(res, dist1[i]+dist2[i]+distR[i]);
        }
        return res;
    }

    private void distance(int n, HashMap<Integer, Integer>[] graph, int src, long[] dist) {
        boolean[] onQueue = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        queue.offer(src);
        onQueue[src] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            onQueue[v] = false;
            if (graph[v] == null) {
                continue;
            }
            for (int adj : graph[v].keySet()) {
                if (dist[adj] <= dist[v] + graph[v].get(adj)) {
                    continue;
                }
                dist[adj] = dist[v]+graph[v].get(adj);
                if (!onQueue[adj]) {
                    queue.offer(adj);
                    onQueue[adj] = true;
                }
            }
        }
    }
}
