public class S0101SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            if (left.val != right.val) {
                return false;
            }

            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
    }
}
