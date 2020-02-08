import util.TreeNode;

public class S0979DistributeCoinsBinaryTree {
    public int distributeCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }
        assert balance(root) == 0;
        int res = 0;
        int left = Math.abs(balance(root.left));
        int right = Math.abs(balance(root.right));
        res = left + right + distributeCoins(root.left) + distributeCoins(root.right);
        return res;
    }

    private int balance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val-1;
        }
        return balance(root.left) + balance(root.right) + root.val - 1;
    }
}
