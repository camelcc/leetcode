import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class S1192CriticalConnectionsNetwork {
    private int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> conn : connections) {
            graph[conn.get(0)].add(conn.get(1));
            graph[conn.get(1)].add(conn.get(0));
        }

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] disc = new int[n];
        int[] lower = new int[n];

        HashSet<String> critical = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i, visited, disc, lower, parent, graph, res);
        }

        return res;
    }

    private void dfs(int u, boolean[] visited, int[] disc, int[] lower, int[] parent, List<Integer>[] graph, List<List<Integer>> res) {
        visited[u] = true;
        time++;
        disc[u] = time;
        lower[u] = time;

        for (int adj : graph[u]) {
            if (visited[adj]) {
                if (adj != parent[u]) {
                    lower[u] = Math.min(lower[u], disc[adj]);
                }
            } else {
                parent[adj] = u;
                dfs(adj, visited, disc, lower, parent, graph, res);
                lower[u] = Math.min(lower[u], lower[adj]);
                if (lower[adj] > disc[u]) {
                    List<Integer> t = new ArrayList<>();
                    t.add(u);
                    t.add(adj);
                    res.add(t);
                }
            }
        }
    }
}
