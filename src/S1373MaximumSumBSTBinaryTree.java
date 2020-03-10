import util.TreeNode;

public class S1373MaximumSumBSTBinaryTree {
    public int maxSumBST(TreeNode root) {
        int[] res = traversal(root);
        return res[1];
    }

    // {isBST, maxSum, sum, min, max}
    private int[] traversal(TreeNode root) {
        assert root != null;
        if (root.left == null && root.right == null) {
            return new int[]{1, root.val, root.val, root.val, root.val};
        }
        boolean isBST = true;
        int res = 0;
        int min = root.val, max = root.val, sum = root.val;

        int[] left = null;
        if (root.left != null) {
            left = traversal(root.left);
            if (left[0] == 0 || left[4] >= root.val) {
                isBST = false;
            } else {
                min = left[3];
            }
            sum += left[2];
            res = Math.max(res, left[1]);
        }
        int[] right = null;
        if (root.right != null) {
            right = traversal(root.right);
            if (right[0] == 0 || right[3] <= root.val) {
                isBST = false;
            } else {
                max = right[4];
            }
            sum += right[2];
            res = Math.max(res, right[1]);
        }
        if (isBST) {
            res = Math.max(res, sum);
        }
        return new int[]{isBST ? 1 : 0, res, sum, min, max};
    }
}
