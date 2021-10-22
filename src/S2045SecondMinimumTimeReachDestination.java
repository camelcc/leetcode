import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class S2045SecondMinimumTimeReachDestination {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        HashSet<Integer>[] adjs = new HashSet[n+1];
        for (int i = 0; i < n+1; i++) {
            adjs[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            adjs[edge[0]].add(edge[1]);
            adjs[edge[1]].add(edge[0]);
        }

        int[][] min = new int[2][n+1];
        Arrays.fill(min[0], Integer.MAX_VALUE);
        LinkedList<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{1, 0});
        while (!bfs.isEmpty()) {
            int[] i = bfs.poll();
            int v = i[0], t = i[1];
            boolean green = (t/change)%2 == 0;
            int nt = green ? t : (1+t/change)*change;
            if (t < min[0][v]) {
                min[1][v] = min[0][v];
                min[0][v] = t;
                for (int adj : adjs[v]) {
                    bfs.offer(new int[]{adj, nt+time});
                }
            } else if (t == min[0][v]) {
                continue;
            } else if (t < min[1][v]) {
                min[1][v] = t;
                for (int adj : adjs[v]) {
                    bfs.offer(new int[]{adj, nt+time});
                }
            }
        }
        return min[1][n];
    }
}
