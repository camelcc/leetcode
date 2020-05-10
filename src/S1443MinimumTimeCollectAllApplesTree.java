import java.util.HashSet;
import java.util.List;

public class S1443MinimumTimeCollectAllApplesTree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashSet<Integer>[] connected = new HashSet[n];
        for (int i = 0; i < n; i++) {
            connected[i] = new HashSet<>();
        }
        for (int[] edge: edges) {
            connected[edge[0]].add(edge[1]);
            connected[edge[1]].add(edge[0]);
        }
        int counts = time(0, -1, connected, hasApple)[1];
        return 2*counts;
    }

    private int[] time(int node, int parent, HashSet<Integer>[] edges, List<Boolean> hasApple) {
        // {0, 0} means no apple
        // {1, X} means have apple, and edges
        int[] res = new int[]{0, 0};
        if (hasApple.get(node)) {
            res[0] = 1;
        }
        if (edges[node].isEmpty()) {
            return res;
        }
        for (int c : edges[node]) {
            if (c == parent) {
                continue;
            }
            int[] t = time(c, node, edges, hasApple);
            if (t[0] == 1) {
                res[0] = 1;
                res[1] += t[1]+1;
            }
        }
        return res;
    }
}
