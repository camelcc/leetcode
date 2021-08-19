import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class S1971FindPathExistsGraph {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] adjs = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adjs[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            adjs[edge[0]].add(edge[1]);
            adjs[edge[1]].add(edge[0]);
        }
        Queue<Integer> bfs = new ArrayDeque<>();
        bfs.offer(start);
        while (!bfs.isEmpty()) {
            int v = bfs.poll();
            if (v == end) {
                return true;
            }
            visited[v] = true;
            for (int a : adjs[v]) {
                if (!visited[a]) {
                    bfs.offer(a);
                }
            }
        }
        return false;
    }
}
