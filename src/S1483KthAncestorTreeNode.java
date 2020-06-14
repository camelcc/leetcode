public class S1483KthAncestorTreeNode {
    public static class TreeAncestor {
        Integer[][] parents;
        int[] pt;

        public TreeAncestor(int n, int[] parent) {
            pt = parent;

            parents = new Integer[n][100];
            parents[0][0] = 0;
            parents[0][1] = -1;

            for (int i = 1; i < parent.length; i++) {
                parents[i][0] = i;

                int k = 1, jump = 0;
                int p = i, j = 0;
                while (p != -1) {
                    p = parent[p];
                    j++;
                    if (j == (0x1 << jump)) {
                        parents[i][k++] = p;
                        jump++;
                    }
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            if (k == 1) {
                return parents[node][k];
            }

            int c = 0x1, j = 1;
            while ((c << 1) <= k) {
                j++;
                c = c << 1;
            }
            if (parents[node][j] == null || parents[node][j] == -1) {
                return -1;
            }
            if (c == k) {
                return parents[node][j];
            }
            int p = parents[node][j], r = k-c;
            return getKthAncestor(p, r);
        }
    }
}
