import java.util.HashSet;

public class S1761MinimumDegreeConnectedTrioGraph {
    public int minTrioDegree(int n, int[][] edges) {
        HashSet<Integer>[] adjs = new HashSet[n+1];
        for (int i = 0; i < adjs.length; i++) {
            adjs[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjs[u].add(v);
            adjs[v].add(u);
        }
        int res = -1;
        for (int i = 1; i <= n; i++) {
            if (adjs[i].size() < 2) {
                continue;
            }
            // i, j, k
            for (int j : adjs[i]) {
                if (j < i) {
                    continue;
                }
                for (int k : adjs[i]) {
                    if (k < j) {
                        continue;
                    }
                    if (!adjs[j].contains(k)) {
                        continue;
                    }
                    // trio
                    int d = adjs[i].size()+adjs[j].size()+adjs[k].size()-6;
                    if (res == -1) {
                        res = d;
                    } else {
                        res = Math.min(res, d);
                    }
                }
            }
        }
        return res;
    }
}
