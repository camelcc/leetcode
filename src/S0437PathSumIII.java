public class S0437PathSumIII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, false);
    }

    private int pathSum(TreeNode root, int sum, boolean continuePath) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res = 1;
        }
        if (root.left == null && root.right == null) {
            return res;
        }
        if (root.right != null) {
            res += pathSum(root.right, sum-root.val, true);
            if (!continuePath) {
                res += pathSum(root.right, sum, false);
            }
        }
        if (root.left != null) {
            res += pathSum(root.left, sum-root.val, true);
            if (!continuePath) {
                res += pathSum(root.left, sum, false);
            }
        }
        return res;
    }
}
