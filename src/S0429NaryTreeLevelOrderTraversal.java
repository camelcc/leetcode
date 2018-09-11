import java.util.ArrayList;
import java.util.List;

public class S0429NaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<Node> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<Integer> val = new ArrayList<>();
            List<Node> nextLevel = new ArrayList<>();
            for (Node n : level) {
                val.add(n.val);
                nextLevel.addAll(n.children);
            }

            res.add(val);
            level = nextLevel;
        }
        return res;
    }
}
