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
        if (root == null) {
            return true;
        }
        return height(root, 0) >= 0;
    }

    private int height(TreeNode node, int height) {
        if (node.left == null && node.right == null) {
            return height;
        }

        if (node.left == null || node.right == null) {
            int h = height(node.left == null ? node.right : node.left, height+1);
            if (h == height + 1) {
                return h;
            } else {
                return -1;
            }
        }

        int lh = height(node.left, height+1);
        if (lh < 0) {
            return -1;
        }
        int rh = height(node.right, height+1);
        if (rh < 0) {
            return -1;
        }
        if (lh == rh || Math.max(lh, rh) == Math.min(lh, rh) + 1) {
            return Math.max(lh, rh);
        } else {
            return -1;
        }
    }
}
