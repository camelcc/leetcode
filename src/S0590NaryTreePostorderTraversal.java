import java.util.ArrayList;
import java.util.List;

public class S0590NaryTreePostorderTraversal {
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

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        for (Node n : root.children) {
            res.addAll(postorder(n));
        }
        res.add(root.val);
        return res;
    }
}
