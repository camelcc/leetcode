import util.TreeNode;

public class S0124BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return max;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        max = Math.max(max, node.val+left+right);
        return Math.max(left, right)+node.val;
    }
}
