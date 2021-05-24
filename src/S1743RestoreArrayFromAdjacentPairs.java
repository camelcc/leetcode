import java.util.HashMap;

public class S1743RestoreArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, Integer[]> map = new HashMap<>();
        for (int[] adj : adjacentPairs) {
            int v1 = adj[0], v2 = adj[1];
            map.putIfAbsent(v1, new Integer[2]);
            map.putIfAbsent(v2, new Integer[2]);
            if (map.get(v1)[0] == null) {
                map.get(v1)[0] = v2;
            } else if (map.get(v1)[1] == null) {
                map.get(v1)[1] = v2;
            }
            if (map.get(v2)[0] == null) {
                map.get(v2)[0] = v1;
            } else if (map.get(v2)[1] == null) {
                map.get(v2)[1] = v1;
            }
        }
        Integer candidate = null;
        for (int k : map.keySet()) {
            Integer[] v = map.get(k);
            if (v[1] == null) {
                candidate = k;
            }
        }

        int[] res = new int[adjacentPairs.length+1];
        int p = 0;
        while (candidate != null) {
            res[p++] = candidate;
            Integer n = map.get(candidate)[0];
            if (n == null) {
                n = map.get(candidate)[1];
            }
            if (n == null) {
                break;
            }
            if (candidate.equals(map.get(n)[0])) {
                map.get(n)[0] = null;
            } else if (candidate.equals(map.get(n)[1])) {
                map.get(n)[1] = null;
            }
            candidate = n;
        }
        return res;
    }
}
