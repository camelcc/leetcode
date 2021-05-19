import java.util.HashMap;
import java.util.HashSet;

public class S1722MinimizeHammingDistanceAfterSwapOperations {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int[] parent = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : allowedSwaps) {
            int r1 = root(parent, edge[0]);
            int r2 = root(parent, edge[1]);
            parent[r2] = r1;
        }

        HashMap<Integer, HashSet<Integer>> groups = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> cnt = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            int r = root(parent, i);
            groups.putIfAbsent(r, new HashSet<>());
            cnt.putIfAbsent(r, new HashMap<>());
            groups.get(r).add(i);
            cnt.get(r).put(source[i], cnt.get(r).getOrDefault(source[i], 0)+1);
        }

        int common = 0;
        for (int g : groups.keySet()) {
            HashMap<Integer, Integer> c = cnt.get(g);
            for (int i : groups.get(g)) {
                int v = target[i];
                if (c.containsKey(v)) {
                    if (c.get(v) == 1) {
                        c.remove(v);
                    } else {
                        c.put(v, c.get(v)-1);
                    }
                    common++;
                }
            }
        }
        return source.length-common;
    }

    private int root(int[] data, int i) {
        while (i != data[i]) {
            i = data[i];
        }
        return i;
    }
}
