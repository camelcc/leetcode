public class S1026MaximumDifferenceBetweenNodeAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return max(root, root.val, root.val);
    }

    private int max(TreeNode root, int max, int min) {
        assert root != null;
        int res = Math.max(Math.abs(max-root.val), Math.abs(min-root.val));
        if (root.left == null && root.right == null) {
            return res;
        } else if (root.left == null) {
            return Math.max(res, max(root.right, Math.max(max, root.val), Math.min(min, root.val)));
        } else if (root.right == null) {
            return Math.max(res, max(root.left, Math.max(max, root.val), Math.min(min, root.val)));
        } else {
            return Math.max(res,
                    Math.max(
                            max(root.left,
                                    Math.max(max, root.val),
                                    Math.min(min, root.val)),
                            max(root.right,
                                    Math.max(max, root.val),
                                    Math.min(min, root.val))));
        }
    }
}
