import util.TreeNode;

public class S0700SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else { // root.val > val
            return searchBST(root.left, val);
        }
    }
}
