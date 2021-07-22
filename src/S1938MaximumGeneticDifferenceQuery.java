import java.util.ArrayList;

// https://leetcode.com/problems/maximum-genetic-difference-query/discuss/1344913/C%2B%2BJavaPython-DFS-and-Trie-and-Compute-queries-by-nodes-Clean-and-Concise
public class S1938MaximumGeneticDifferenceQuery {
    class TrieNode {
        TrieNode[] child = new TrieNode[2];
        int go = 0; // Number of elements goes through this node

        public void increase(int number, int d) {
            TrieNode cur = this;
            for (int i = 17; i >= 0; --i) {
                int bit = (number >> i) & 1;
                if (cur.child[bit] == null) cur.child[bit] = new TrieNode();
                cur = cur.child[bit];
                cur.go += d;
            }
        }
        public int findMax(int number) {
            TrieNode cur = this;
            int ans = 0;
            for (int i = 17; i >= 0; --i) {
                int bit = (number >> i) & 1;
                if (cur.child[1 - bit] != null && cur.child[1 - bit].go > 0) {
                    cur = cur.child[1 - bit];
                    ans |= (1 << i);
                } else cur = cur.child[bit];
            }
            return ans;
        }
    }

    TrieNode trieRoot = new TrieNode();

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int n = parents.length, m = queries.length, root = -1;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; ++i) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (parents[i] == -1) root = i;
            else graph[parents[i]].add(i);

        ArrayList<int[]>[] queryByNode = new ArrayList[n];
        for (int i = 0; i < n; ++i) queryByNode[i] = new ArrayList<>();
        for (int i = 0; i < m; ++i)
            queryByNode[queries[i][0]].add(new int[]{queries[i][1], i}); // node -> list of pairs (val, idx)

        int[] ans = new int[m];
        dfs(root, graph, queryByNode, ans);
        return ans;
    }

    void dfs(int u, ArrayList<Integer>[] graph, ArrayList<int[]>[] queryByNode, int[] ans) {
        trieRoot.increase(u, 1);
        for (int[] p : queryByNode[u])
            ans[p[1]] = trieRoot.findMax(p[0]);
        for (int v: graph[u])
            dfs(v, graph, queryByNode, ans);
        trieRoot.increase(u, -1);
    }
}
