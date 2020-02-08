import util.TreeNode;

public class S0671SecondMinimumNodeBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }
        // root != null, root.left != null, root.right != null
        int min = root.val;
        return min(root, min);
    }

    private int min(TreeNode root, int except) {
        if (root == null) {
            return -1;
        }
        if (root.val != except) {
            return root.val;
        }
        // root.val = except
        if (root.left == null) {
            return -1;
        }
        int left = min(root.left, except);
        int right = min(root.right, except);
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return Math.min(left, right);
    }
}
