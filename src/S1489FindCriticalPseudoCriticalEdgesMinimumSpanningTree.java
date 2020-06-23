import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class S1489FindCriticalPseudoCriticalEdgesMinimumSpanningTree {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for (int[] e : edges) {
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        boolean[] visited = new boolean[n];

        visit(n, graph, visited, 0, pq);
        int mst = mst(n, graph, visited, 0, pq);

        for (int i = 0; i < edges.length; i++) {
            // with this edge
            visited = new boolean[n];
            visited[edges[i][0]] = true;
            visited[edges[i][1]] = true;
            pq.clear();
            visit(n, graph, visited, edges[i][0], pq);
            visit(n, graph, visited, edges[i][1], pq);
            int vc = mst(n, graph, visited, edges[i][2], pq);

            // without this edge
            int w = edges[i][2];
            graph[edges[i][0]][edges[i][1]] = 0;
            graph[edges[i][1]][edges[i][0]] = 0;
            visited = new boolean[n];
            pq.clear();
            visit(n, graph, visited, 0, pq);
            int wc = mst(n, graph, visited, 0, pq);
            boolean connected = connected(visited);
            graph[edges[i][0]][edges[i][1]] = w;
            graph[edges[i][1]][edges[i][0]] = w;

            if (!connected || wc > mst) {
                critical.add(i);
            } else {
                if (mst == vc) {
                    pseudo.add(i);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(critical);
        res.add(pseudo);
        return res;
    }

    private boolean connected(boolean[] visited) {
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private int mst(int n, int[][] graph, boolean[] visited, int cost, PriorityQueue<int[]> pq) {
        int res = cost;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int v = edge[0], w = edge[1];
            if (visited[v] && visited[w]) {
                continue;
            }
            res += edge[2];
            if (!visited[v]) { visit(n, graph, visited, v, pq); }
            if (!visited[w]) { visit(n, graph, visited, w, pq); }
        }
        return res;
    }

    private void visit(int n, int[][] graph, boolean[] visited, int v, PriorityQueue<int[]> pq) {
        visited[v] = true;
        for (int i = 0; i < n; i++) {
            if (graph[v][i] > 0 && !visited[i]) {
                pq.offer(new int[]{v, i, graph[v][i]});
            }
        }
    }
}
