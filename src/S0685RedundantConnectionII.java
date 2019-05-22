public class S0685RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int N = edges.length;
        int[] parent = new int[N+1];
        int[] can1 = null, can2 = null;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (parent[edge[1]] == 0) {
                parent[edge[1]] = edge[0];
            } else {
                can1 = new int[] {parent[edge[1]], edge[1]};
                can2 = new int[] {edge[0], edge[1]};
                edges[i][1] = 0;
            }
        }
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int p = edge[0], c = edge[1];
            if (root(parent, p) == c) {
                // circle
                if (can1 == null) {
                    return edge;
                }
                return can1;
            }
            parent[c] = p;
        }
        return can2;
    }

    private int root(int[] root, int i) {
        while (root[i] != i) {
            i = root[i];
        }
        return i;
    }
}
