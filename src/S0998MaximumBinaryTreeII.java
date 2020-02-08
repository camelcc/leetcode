import util.TreeNode;

public class S0998MaximumBinaryTreeII {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
