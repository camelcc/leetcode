public class S0998MaximumBinaryTreeII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

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
