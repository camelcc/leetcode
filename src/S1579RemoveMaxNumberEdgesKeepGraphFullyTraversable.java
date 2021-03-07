public class S1579RemoveMaxNumberEdgesKeepGraphFullyTraversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
            b[i] =i;
        }
        int res = 0, al = 0, bl = 0;
        int[] ta = construct(edges, 3, a, 0);
        res += ta[0];
        al = ta[1];
        int[] tb = construct(edges, 3, b, 0);
        bl = tb[1];

        ta = construct(edges, 1, a, al);
        res += ta[0];
        al = ta[1];

        tb = construct(edges, 2, b, bl);
        res += tb[0];
        bl = tb[1];

        if (al != n-1 || bl != n-1) {
            return -1;
        }
        return res;
    }

    private int[] construct(int[][] edges, int type, int[] graph, int len) {
        int l = len, del = 0;
        for (int[] edge : edges) {
            if (edge[0] != type) {
                continue;
            }
            int ra = root(graph, edge[1]);
            int rb = root(graph, edge[2]);
            if (ra == rb) {
                del++;
                continue;
            }
            graph[ra] = graph[rb];
            l++;
        }
        return new int[]{del, l};
    }

    private int root(int[] graph, int i) {
        if (graph[i] == i) {
            return i;
        }
        graph[i] = root(graph, graph[i]);
        return graph[i];
    }
}
