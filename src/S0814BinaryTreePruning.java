import util.TreeNode;

public class S0814BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        assert root != null;
        if (root.left != null) {
            root.left = pruneTree(root.left);
        }
        if (root.right != null) {
            root.right = pruneTree(root.right);
        }

        if (root.val == 0) {
            if (root.left == null && root.right == null) {
                return null;
            }
        }
        return root;
    }
}
