import java.util.List;

public class S0559MaximumDepthNaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }
        int max = -1;
        for (Node c : root.children) {
            int d = maxDepth(c);
            if (max < d) {
                max = d;
            }
        }
        return max + 1;
    }
}
