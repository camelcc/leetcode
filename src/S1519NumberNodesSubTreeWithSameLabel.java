import java.util.HashMap;
import java.util.HashSet;

public class S1519NumberNodesSubTreeWithSameLabel {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Integer, HashSet<Integer>> adjs = new HashMap<>();
        for (int[] edge : edges) {
            int e1 = edge[0], e2 = edge[1];
            adjs.putIfAbsent(e1, new HashSet<>());
            adjs.putIfAbsent(e2, new HashSet<>());
            adjs.get(e1).add(e2);
            adjs.get(e2).add(e1);
        }
        boolean[] visited = new boolean[n];
        int[] res = new int[n];
        dfs(visited, res, 0, adjs, labels);
        return res;
    }

    private int[] dfs(boolean[] visited, int[] res, int c, HashMap<Integer, HashSet<Integer>> adjs, String labels) {
        visited[c] = true;
        int[] cnt = new int[26];
        char ch = labels.charAt(c);
        cnt[ch-'a']++;

        for (int adj : adjs.getOrDefault(c, new HashSet<>())) {
            if (visited[adj]) { // parent
                continue;
            }
            // children
            int[] child = dfs(visited, res, adj, adjs, labels);
            for (int i = 0; i < 26; i++) {
                cnt[i] += child[i];
            }
        }

        res[c] = cnt[ch-'a'];
        return cnt;
    }
}
