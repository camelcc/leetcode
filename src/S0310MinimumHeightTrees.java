import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S0310MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        if (n == 1) {
            res.add(n-1);
            return res;
        }
        if (n == 2) {
            res.add(0);
            res.add(1);
            return res;
        }

        List<Set<Integer>> adjs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjs.add(new HashSet<>(adj(edges, i)));
        }

        List<Integer> leafs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adjs.get(i).size() == 1) {
                leafs.add(i);
            }
        }
        while (n > 2) {
            n -= leafs.size();
            List<Integer> upper = new ArrayList<>();
            for (int l : leafs) {
                int u = adjs.get(l).iterator().next();
                adjs.get(u).remove(l);
                if (adjs.get(u).size() == 1) {
                    upper.add(u);
                }
                adjs.get(l).clear();
            }
            leafs = upper;
        }
        return leafs;
    }

    private List<Integer> adj(int[][] edges, int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == n) {
                res.add(edges[i][1]);
            } else if (edges[i][1] == n) {
                res.add(edges[i][0]);
            }
        }
        return res;
    }
}
