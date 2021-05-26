import java.util.*;

public class S1766TreeCoprimes {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        boolean[][] gcd = new boolean[51][51];
        for (int i = 1; i <= 50; i++) {
            for (int j = i; j <= 50; j++) {
                boolean g = gcd(i, j) == 1;
                gcd[i][j] = g;
                gcd[j][i] = g;
            }
        }

        HashSet<Integer>[] adj = new HashSet[nums.length];
        for (int i = 0; i < nums.length; i++) {
            adj[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[nums.length];
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int[] ancestor = new int[51];
        Arrays.fill(ancestor ,-1);
        int[] depth = new int[51];
        Arrays.fill(depth, -1);
        dfs(nums, adj, gcd, res, visited, ancestor, depth, 0, 0);
        return res;
    }

    private void dfs(int[] nums, HashSet<Integer>[] adj, boolean[][] gcd, int[] res, boolean[] visited, int[] ancestor, int[] depth, int i, int level) {
        // cal gcd
        int a = -1, d = -1;
        for (int v = 1; v < 51; v++) {
            if (!gcd[v][nums[i]] || ancestor[v] == -1) {
                continue;
            }
            if (depth[v] > d) {
                a = ancestor[v];
                d = depth[v];
            }
        }
        res[i] = a;
        visited[i] = true;
        int[] na = Arrays.copyOf(ancestor, ancestor.length);
        na[nums[i]] = i;
        int[] nd = Arrays.copyOf(depth, depth.length);
        nd[nums[i]] = level;
        for (int c : adj[i]) {
            if (visited[c]) {
                continue;
            }
            dfs(nums, adj, gcd, res, visited, na, nd, c, level+1);
        }
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
