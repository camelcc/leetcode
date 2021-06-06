import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

// https://leetcode.com/problems/largest-color-value-in-a-directed-graph/discuss/1234806/Java-DFS-%2B-dp-solution-and-Topological-sort-%2B-dp-solution
public class S1857LargestColorValueDirectedGraph {
    public int largestPathValue(String colors, int[][] edges) {
        int N = colors.length();
        int[] indegree = new int[N];
        HashMap<Integer, HashSet<Integer>> adjs = new HashMap<>();
        for (int[] edge : edges) {
            adjs.putIfAbsent(edge[0], new HashSet<>());
            adjs.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        int res = 0;
        int[][] dp = new int[N][26];
        LinkedList<Integer> zero = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                zero.offer(i);
                dp[i][colors.charAt(i)-'a'] = 1;
                res = 1;
            }
        }
        int processed = 0;
        while (!zero.isEmpty()) {
            int i = zero.poll();
            processed++;
            for (int adj : adjs.getOrDefault(i, new HashSet<>())) {
                for (int c = 0; c < 26; c++) {
                    int v = c == colors.charAt(adj)-'a' ? 1 : 0;
                    dp[adj][c] = Math.max(dp[adj][c], dp[i][c]+v);
                    res = Math.max(res, dp[adj][c]);
                }
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    zero.offer(adj);
                }
            }
        }
        if (processed != N) {
            return -1;
        }
        return res;
    }
}
