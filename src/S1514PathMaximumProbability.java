import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S1514PathMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<int[]>[] adjs = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjs[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            adjs[edge[0]].add(new int[]{edge[1], i});
            adjs[edge[1]].add(new int[]{edge[0], i});
        }

        double[] prob = new double[n];
        LinkedList<double[]> bfs = new LinkedList<>();
        bfs.offer(new double[]{start, 1.0});
        while (!bfs.isEmpty()) {
            double[] t = bfs.poll();
            int v = (int)t[0];
            double p = t[1];
            if (prob[v] >= p) {
                continue;
            }
            prob[v] = p;
            // bfs on node v
            for (int[] adj : adjs[v]) {
                bfs.offer(new double[]{adj[0], p * succProb[adj[1]]});
            }
        }

        return prob[end];
    }
}
