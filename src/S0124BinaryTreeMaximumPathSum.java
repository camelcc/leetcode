public class S0124BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        int sl = maxSide(root, true) - root.val;
        int sr = maxSide(root, false) - root.val;
        int res = root.val;
        if (sl > 0) {
            res += sl;
        }
        if (sr > 0) {
            res += sr;
        }
        if (root.left != null) {
            res = Math.max(res, maxPathSum(root.left));
        }
        if (root.right != null) {
            res = Math.max(res, maxPathSum(root.right));
        }
        return res;
    }

    private int maxSide(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }
        int res = root.val;
        if (left) {
            if (root.left == null) {
                return root.val;
            } else {
                int cl = maxSide(root.left, true);
                int cr = maxSide(root.left, false);
                res = Math.max(res, res + Math.max(cl, cr));
            }
        } else {
            if (root.right == null) {
                return root.val;
            } else {
                int cl = maxSide(root.right, true);
                int cr = maxSide(root.right, false);
                res = Math.max(res, res + Math.max(cl, cr));
            }
        }
        return res;
    }
}
