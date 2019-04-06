import javafx.util.Pair;

public class S0865SmallestSubtreeDeepestNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        Pair<TreeNode, Integer> res = deepest(root, 0);
        return res.getKey();
    }

    private Pair<TreeNode, Integer> deepest(TreeNode node, int depth) {
        Pair<TreeNode, Integer> left = null;
        if (node.left != null) {
            left = deepest(node.left, depth+1);
        }
        Pair<TreeNode, Integer> right = null;
        if (node.right != null) {
            right = deepest(node.right, depth+1);
        }
        if (left == null && right == null) {
            return new Pair<>(node, depth);
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            if (left.getValue() < right.getValue()) {
                return right;
            } else if (left.getValue() == right.getValue()) {
                return new Pair<>(node, left.getValue());
            } else {
                return left;
            }
        }
    }
}
