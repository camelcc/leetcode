import util.TreeNode;

import java.util.HashMap;

public class S0865SmallestSubtreeDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        return deepest(root, 0, new HashMap<>());
    }

    private TreeNode deepest(TreeNode node, int depth, HashMap<Integer, Integer> dp) {
        dp.put(node.val, depth);

        if (node.left == null && node.right == null) {
            return node;
        } else if (node.left == null) {
            return deepest(node.right, depth+1, dp);
        } else if (node.right == null) {
            return deepest(node.left, depth+1, dp);
        } else {
            TreeNode left = deepest(node.left, depth+1, dp);
            TreeNode right = deepest(node.right, depth+1, dp);

            if (dp.get(left.val) < dp.get(right.val)) {
                return right;
            } else if (dp.get(left.val) == dp.get(right.val)) {
                dp.put(node.val, dp.get(left.val));
                return node;
            } else {
                return left;
            }
        }
    }
}
