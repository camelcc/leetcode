import java.util.HashSet;
import java.util.LinkedList;

public class S1378FrogPositionAfterTSeconds {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        boolean[][] adj = new boolean[n+1][n+1];
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            adj[a][b] = true;
            adj[b][a] = true;
        }
        boolean[] visited = new boolean[n+1];
        boolean[] leaf = new boolean[n+1];
        visited[0] = true;
        int[][] dp = new int[n+1][2];
        LinkedList<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{1, 0, 1});
        while (!bfs.isEmpty()) {
            int[] b = bfs.poll();
            int v = b[0], time = b[1], p = b[2];
            dp[v] = new int[]{time, p};
            visited[v] = true;

            HashSet<Integer> children = new HashSet<>();
            for (int i = 0; i < n+1; i++) {
                if (!adj[v][i] || visited[i]) {
                    continue;
                }

                children.add(i);
            }
            leaf[v] = children.isEmpty();

            for (int c : children) {
                bfs.offer(new int[]{c, time+1, p*children.size()});
            }
        }

        int[] r = dp[target];
        if (r[0] < t) {
            if (leaf[target]) {
                return 1.0/r[1];
            } else {
                return 0;
            }
        } else if (r[0] == t) {
            return 1.0/r[1];
        } else {
            return 0;
        }
    }
}
