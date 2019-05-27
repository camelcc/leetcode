public class S0765CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int N = row.length/2;
        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int components = N;

        for (int i = 0; i < N; i++) {
            int a = row[2*i];
            int b = row[2*i+1];

            if (!connected(parent, a/2, b/2)) {
                components--;
            }
        }

        return N-components;
    }

    private boolean connected(int[] parent, int u, int v) {
        int rootU = root(parent, u);
        int rootV = root(parent, v);
        if (rootU == rootV) {
            return true;
        }

        parent[rootU] = rootV;
        return false;
    }

    private int root(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }

        parent[i] = root(parent, parent[i]);
        return parent[i];
    }
}
