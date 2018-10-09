public class S0427ConstructQuadTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int l, int t, int len) {
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return new Node(grid[t][l] == 1, true, null, null, null, null);
        }
        int N = len;
        int V = grid[t][l];
        boolean same = true;
        for (int i = t; i < t+N; i++) {
            for (int j = l; j < l+N; j++) {
                if (grid[i][j] != V) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                break;
            }
        }
        if (same) {
            return new Node(V == 1, true, null, null, null, null);
        }
        return new Node(true, false, construct(grid, l, t, N/2),
                construct(grid, l+N/2, t, N/2),
                construct(grid, l, t+N/2, N/2),
                construct(grid, l+N/2, t+N/2, N/2));
    }
}
