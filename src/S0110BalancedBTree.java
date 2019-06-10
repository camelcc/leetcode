public class S0110BalancedBTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lh = height(node.left);
        if (lh < 0) {
            return -1;
        }
        int rh = height(node.right);
        if (rh < 0) {
            return -1;
        }
        if (lh == rh || Math.max(lh, rh) == Math.min(lh, rh) + 1) {
            return Math.max(lh, rh)+1;
        } else {
            return -1;
        }
    }
}
