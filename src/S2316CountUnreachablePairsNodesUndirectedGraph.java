public class S2316CountUnreachablePairsNodesUndirectedGraph {
    public long countPairs(int n, int[][] edges) {
        int[] root = new int[n];
        long[] cnt = new long[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            cnt[i] = 1;
        }

        for (int[] edge : edges) {
            int re1 = root(root, edge[0]);
            int re2 = root(root, edge[1]);
            if (re1 != re2) {
                if (re1 < re2) {
                    root[re2] = re1;
                    cnt[re1] += cnt[re2];
                } else {
                    root[re1] = re2;
                    cnt[re2] += cnt[re1];
                }
            }
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += n-cnt[root(root, i)];
        }
        return res/2;
    }

    private int root(int[] root, int i) {
        while (i != root[i]) {
            i = root[i];
        }
        return i;
    }
}
