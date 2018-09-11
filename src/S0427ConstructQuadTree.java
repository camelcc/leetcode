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
        if (grid.length == 0) {
            return null;
        }
        if (grid.length == 1) {
            return new Node(grid[0][0] == 1, true, null, null, null, null);
        }

        int N = grid.length;
        int V = grid[0][0];
        boolean same = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
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

        int[][] lt = new int[N/2][N/2];
        int[][] rt = new int[N/2][N/2];
        int[][] lb = new int[N/2][N/2];
        int[][] rb = new int[N/2][N/2];
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < N/2; j++) {
                lt[i][j] = grid[i][j];
                rt[i][j] = grid[i][j+N/2];
                lb[i][j] = grid[i+N/2][j];
                rb[i][j] = grid[i+N/2][j+N/2];
            }
        }
        return new Node(true, false, construct(lt), construct(rt), construct(lb), construct(rb));
    }
}
