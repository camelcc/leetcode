public class S0098ValidateBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // leaf
        if (root.left == null && root.right == null) {
            return true;
        }
        if (!isValidBST(root.left) || !isValidBST(root.right)) {
            return false;
        }
        if ((root.left != null && root.val <= max(root.left)) ||
            (root.right != null && root.val >= min(root.right))) {
            return false;
        }

        return true;
    }

    private int max(TreeNode root) {
        int val = root.val;

        while (root != null) {
            val = root.val;
            root = root.right;
        }
        return val;
    }

    private int min(TreeNode root) {
        int val = root.val;

        while (root != null) {
            val = root.val;
            root = root.left;
        }

        return val;
    }
}
