import util.TreeNode;

public class S0938RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        assert L <= R;
        if (root == null) {
            return 0;
        }

        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val == L) {
            return root.val + rangeSumBST(root.right, L, R);
        } else if (root.val > L && root.val < R) {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        } else if (root.val > L && root.val == R) {
            return root.val + rangeSumBST(root.left, L, R);
        } else if (root.val > L && root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        throw new IllegalArgumentException("invalid L R");
    }
}
