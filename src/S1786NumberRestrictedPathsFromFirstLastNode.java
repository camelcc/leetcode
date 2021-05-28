import java.util.*;

// https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/discuss/1203890/Dijkstra-%2B-DFS-memoization
public class S1786NumberRestrictedPathsFromFirstLastNode {
    int mod = 1000000007;
    public int countRestrictedPaths(int n, int[][] edges) {
        int[] dis = new int[n + 1]; // [0,1,2,3,4,5]
        Arrays.fill(dis, Integer.MAX_VALUE);
        Map<Integer, List<int[]>> adjs = new HashMap<>();
        for (int[] edge : edges) {
            if (!adjs.containsKey(edge[0])) adjs.put(edge[0], new ArrayList<>());
            if (!adjs.containsKey(edge[1])) adjs.put(edge[1], new ArrayList<>());
            adjs.get(edge[0]).add(new int[]{edge[1], edge[2]}); // [target, weight]
            adjs.get(edge[1]).add(new int[]{edge[0], edge[2]}); // [target, weight]
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); //[target, weight]
        pq.offer(new int[]{n, 0});
        dis[n] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            List<int[]> children = adjs.get(cur[0]);
            if (children == null || children.size() == 0) continue;
            for (int[] child : children) {
                if (child[1] + cur[1] < dis[child[0]]) {
                    dis[child[0]] = child[1] + cur[1];
                    pq.offer(new int[]{child[0], dis[child[0]]});
                }
            }
        }
        //System.out.println(Arrays.toString(dis));

        // use dfs to calculate number of path
        return dfs(dis, 1, n, adjs, new HashMap<>());
    }

    private int dfs(int[] dis, int i, int n, Map<Integer, List<int[]>> adjs, Map<Integer, Integer> map) {
        if (map.containsKey(i)) return map.get(i);
        if (i == n) return 1;
        int res = 0;
        List<int[]> lst = adjs.get(i);
        if (lst != null || lst.size() > 0) {
            for (int[] child : lst) {
                if (dis[child[0]] < dis[i]) {
                    res = (res + dfs(dis, child[0], n, adjs, map)) % mod;
                }
            }
        }
        map.put(i, res);
        return res;
    }
}
