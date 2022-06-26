import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// https://leetcode.com/problems/minimum-score-after-removals-on-a-tree/discuss/2198475/Simple-Java-and-C%2B%2B-solutions.-Iterate-twice-on-the-tree.-O(n2)
public class S2322MinimumScoreAfterRemovalsTree {
    private int ans = Integer.MAX_VALUE;

    private int helper(int src, ArrayList<Integer>[] graph, int[] arr, boolean[] isVis, int block, int xor1, int tot) {
        isVis[src] = true;
        int myXOR = arr[src];

        for (int nbr : graph[src]) {
            if (!isVis[nbr] && nbr != block) {
                int nbrXOR = helper(nbr, graph, arr, isVis, block, xor1, tot);
                int xor2 = nbrXOR;
                int xor3 = (tot ^ xor1) ^ xor2;

                int max = Math.max(xor1, Math.max(xor2, xor3));
                int min = Math.min(xor1, Math.min(xor2, xor3));

                this.ans = Math.min(ans, max - min);
                myXOR ^= nbrXOR;

            }
        }

        return myXOR;
    }

    private int dfs(int src, ArrayList<Integer>[] graph, int[] arr, boolean[] isVis, int tot) {
        isVis[src] = true;
        int myXOR = arr[src];
        for (int nbr : graph[src]) {
            if (!isVis[nbr]) {

                int nbrXOR = dfs(nbr, graph, arr, isVis, tot);
                myXOR ^= nbrXOR;

                helper(0, graph, arr, new boolean[graph.length], nbr, nbrXOR, tot);
            }
        }

        return myXOR;

    }

    public int minimumScore(int[] arr, int[][] edges) {
        int n = arr.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        int tot = 0;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            tot ^= arr[i];
        }


        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }


        this.ans = Integer.MAX_VALUE;

        dfs(0, graph, arr, new boolean[n], tot);

        return this.ans;
    }
}
