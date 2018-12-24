public class S0547FriendCircles {
    public int findCircleNum(int[][] M) {
        if (M.length == 0) {
            return 0;
        }
        int[] parent = new int[M.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int r = 0; r < parent.length; r++) {
            for (int c = r+1; c < parent.length; c++) {
                if (M[r][c] == 0) {
                    continue;
                }
                int t = root(parent, c);
                int p = root(parent, r);
                parent[t] = p;
            }
        }

        int res = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                res++;
            }
        }
        return res;
    }

    private int root(int[] parent, int i) {
        int p = i;
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }
}
