import java.util.Stack;

public class S0785GraphBipartite {
    public boolean isBipartite(int[][] graph) {
        if (graph.length <= 1) {
            return true;
        }
        boolean[] marked = new boolean[graph.length];
        boolean[] color = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (marked[i]) {
                continue;
            }
            Stack<Integer> dfs = new Stack<>();
            dfs.push(i);

            while (!dfs.isEmpty()) {
                int n = dfs.pop();
                marked[n] = true;

                for (int adj : graph[n]) {
                    if (marked[adj]) {
                        if (color[adj] == color[n]) {
                            return false;
                        }
                    } else {
                        color[adj] = !color[n];
                        dfs.push(adj);
                    }
                }
            }
        }
        return true;
    }
}
