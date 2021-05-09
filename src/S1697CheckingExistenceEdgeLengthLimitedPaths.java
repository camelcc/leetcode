import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S1697CheckingExistenceEdgeLengthLimitedPaths {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> queries[o][2]));
        for (int i = 0; i < queries.length; i++) {
            pq.offer(i);
        }
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o[2]));
        int p = 0;
        boolean[] res = new boolean[queries.length];
        while (!pq.isEmpty()) {
            int qi = pq.poll();
            int limit = queries[qi][2];
            while (p < edgeList.length && edgeList[p][2] < limit) {
                union(nodes, edgeList[p][0], edgeList[p][1]);
                p++;
            }
            res[qi] = (root(nodes, queries[qi][0]) == root(nodes, queries[qi][1]));
        }
        return res;
    }

    private void union(int[] n, int i, int j) {
        int ri = root(n, i), rj = root(n, j);
        if (ri != rj) {
            n[rj] = ri;
        }
    }

    private int root(int[] n, int i) {
        while (n[i] != i) {
            i = n[i];
        }
        return i;
    }
}
