import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class S2192AllAncestorsNodeDAG {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> parents = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> children = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> ancestors = new HashMap<>();
        HashSet<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
            roots.add(i);
            children.put(i, new HashSet<>());
            ancestors.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int p = edge[0], c = edge[1];
            parents.put(c, parents.getOrDefault(c, 0)+1);
            children.get(p).add(c);
            roots.remove(c);
        }

        while (!roots.isEmpty()) {
            HashSet<Integer> next = new HashSet<>();
            for (int r : roots) {
                HashSet<Integer> a = ancestors.get(r);
                List<Integer> l = new ArrayList<>(a);
                Collections.sort(l);
                res.set(r, l);

                a.add(r);
                for (int c : children.get(r)) {
                    ancestors.get(c).addAll(a);
                    parents.put(c, parents.get(c)-1);
                    if (parents.get(c) == 0) {
                        next.add(c);
                    }
                }
            }
            roots = next;
        }
        return res;
    }
}
