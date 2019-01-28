public class S0684RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] root = new int[edges.length+1];
        for (int i = 0; i < edges.length+1; i++) {
            root[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            // connect v to u
            if (root(root, u) == root(root, v)) {
                return new int[]{u, v};
            } else {
                int ru = root(root, u);
                int rv = root(root, v);
                if (ru < rv) {
                    root[rv] = ru;
                } else {
                    root[ru] = rv;
                }
            }
        }

        return null;
    }

    private int root(int[] root, int index) {
        while (root[index] != index) {
            index = root[index];
        }
        return index;
    }
}
