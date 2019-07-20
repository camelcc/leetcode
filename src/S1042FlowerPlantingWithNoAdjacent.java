import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class S1042FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        HashMap<Integer, HashSet<Integer>> adjs = new HashMap<>();
        for (int[] path : paths) {
            adjs.putIfAbsent(path[0], new HashSet<>());
            adjs.get(path[0]).add(path[1]);
            adjs.putIfAbsent(path[1], new HashSet<>());
            adjs.get(path[1]).add(path[0]);
        }

        int[] res = new int[N+1];
        for (int i = 1; i <= N; i++) {
            if (res[i] != 0) {
                continue;
            }
            res[i] = 1;
            if (!adjs.containsKey(i) || adjs.get(i).isEmpty()) {
                continue;
            }
            dfs(res, i, adjs);
        }
        return Arrays.copyOfRange(res, 1, res.length);
    }

    private void dfs(int[] garden, int pos, HashMap<Integer, HashSet<Integer>> adjs) {
        assert garden[pos] != 0;
        for (int adj : adjs.get(pos)) {
            if (garden[adj] != 0) {
                continue;
            }
            boolean[] color = new boolean[5];
            for (int a : adjs.get(adj)) {
                if (garden[a] != 0) {
                    color[garden[a]] = true;
                }
            }
            int c = 1;
            while (c < 5 && color[c]) {
                c++;
            }
            assert c < 5;
            garden[adj] = c;
            dfs(garden, adj, adjs);
        }
    }
}
