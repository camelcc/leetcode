public class S0112SumPath {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        int remains = sum - root.val;
        if (root.left == null && root.right == null) {
            return remains == 0;
        }
        if (root.left == null) {
            return hasPathSum(root.right, remains);
        } else if (root.right == null) {
            return hasPathSum(root.left, remains);
        } else {
            return hasPathSum(root.left, remains) || hasPathSum(root.right, remains);
        }
    }
}
