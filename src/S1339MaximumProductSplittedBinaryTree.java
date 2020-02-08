import util.TreeNode;

public class S1339MaximumProductSplittedBinaryTree {
    public int maxProduct(TreeNode root) {
        long total = sum(root);
        int MOD = (int)Math.pow(10, 9)+7;
        return (int)(max(root, total)[1]%MOD);
    }

    private long sum(TreeNode node) {
        return node == null ? 0 : (sum(node.left)+node.val+sum(node.right));
    }

    private long[] max(TreeNode node, long total) {
        long res = 0, sum = node.val;
        if (node.left != null) {
            long[] m = max(node.left, total);
            sum += m[0];
            res = Math.max(res, m[1]);
            res = Math.max(res, m[0]*(total-m[0]));
        }
        if (node.right != null) {
            long[] m = max(node.right, total);
            sum += m[0];
            res = Math.max(res, m[1]);
            res = Math.max(res, m[0]*(total-m[0]));
        }
        return new long[]{sum, res};
    }
}
