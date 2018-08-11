import java.util.ArrayList;
import java.util.List;

public class S0310MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] roots = new int[n];
        int minRoot = Integer.MAX_VALUE;

        for (int root = 0; root < n; root++) {
            boolean[] visited = new boolean[n];
            int[] heights = new int[n];

            int h = 0;
            visited[root] = true;
            heights[root] = 0;
            List<Integer> queue = new ArrayList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int node = queue.remove(0);
                h = heights[node];
                if (h > minRoot) {
                    h = Integer.MAX_VALUE;
                    break;
                }

                for (int adj : adj(edges, node)) {
                    if (!visited[adj] || heights[adj] > heights[node] + 1) {
                        visited[adj] = true;
                        heights[adj] = heights[node] + 1;
                        queue.add(adj);
                    }
                }
            }

            roots[root] = h;
            if (minRoot > h) {
                minRoot = h;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (roots[i] == minRoot) {
                res.add(i);
            }
        }
        return res;
    }

    private List<Integer> adj(int[][] edges, int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == n) {
                res.add(edges[i][1]);
            } else if (edges[i][1] == n) {
                res.add(edges[i][0]);
            }
        }
        return res;
    }
}
