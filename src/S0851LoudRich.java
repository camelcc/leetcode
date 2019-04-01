import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0851LoudRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] r : richer) {
            // r[0] richer than r[1]
            List<Integer> t = map.getOrDefault(r[1], new ArrayList<>());
            if (!t.contains(r[0])) {
                t.add(r[0]);
            }
            map.put(r[1], t);
        }
        HashMap<Integer, Integer> dp = new HashMap<>();

        int[] res = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            res[i] = dfs(map, dp, quiet, i);
        }
        return res;
    }

    private int dfs(HashMap<Integer, List<Integer>> map, HashMap<Integer, Integer> dp, int[] quiet, int index) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        }

        int res = index;
        if (!map.containsKey(index)) {
            dp.put(index, res);
            return res;
        }

        List<Integer> richer = map.get(index);
        for (int r : richer) {
            int q = dfs(map, dp, quiet, r);
            if (quiet[res] > quiet[q]) {
                res = q;
            }
        }
        dp.put(index, res);
        return res;
    }
}
