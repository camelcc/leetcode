import util.TreeNode;

public class S0404SumLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return sumOfLeftLeaves(root.right);
        }

        int sum = sumOfLeftLeaves(root.right);
        TreeNode left = root.left;
        if (left.left == null && left.right == null) {
            sum += left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }
        return sum;
    }
}
