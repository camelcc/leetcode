public class S0530MinimumDifferenceBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        int left = Integer.MAX_VALUE;
        if (root.left != null) {
            left = Math.min(root.val - max(root.left), getMinimumDifference(root.left));
        }
        int right = Integer.MAX_VALUE;
        if (root.right != null) {
            right = Math.min(min(root.right) - root.val, getMinimumDifference(root.right));
        }
        return Math.min(left, right);
    }

    private int min(TreeNode node) {
        if (node.left == null) {
            return node.val;
        }
        return min(node.left);
    }

    private int max(TreeNode node) {
        if (node.right == null) {
            return node.val;
        }
        return max(node.right);
    }
}
