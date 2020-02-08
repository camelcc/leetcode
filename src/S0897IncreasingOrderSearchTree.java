import util.TreeNode;

public class S0897IncreasingOrderSearchTree {
    private TreeNode tail = null;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode res = null;
        if (root.left != null) {
            res = increasingBST(root.left);
        }
        if (res == null) {
            res = new TreeNode(root.val);
            tail = res;
        } else {
            tail.right = new TreeNode(root.val);
            tail = tail.right;
        }
        tail.right = increasingBST(root.right);
        return res;
    }
}
