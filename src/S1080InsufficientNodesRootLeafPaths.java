public class S1080InsufficientNodesRootLeafPaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (insufficient(root, 0, limit)) {
            return null;
        } else {
            return root;
        }
    }

    private boolean insufficient(TreeNode root, int sum, int limit) {
        if (root == null) {
            return sum < limit;
        }
        if (root.left == null && root.right == null) {
            return sum+root.val < limit;
        }

        boolean left = true;
        if (root.left != null) {
            left = insufficient(root.left, sum+root.val, limit);
        }
        if (left) {
            root.left = null;
        }
        boolean right = true;
        if (root.right != null) {
            right = insufficient(root.right, sum+root.val, limit);
        }
        if (right) {
            root.right = null;
        }
        return left && right;
    }
}
