import util.TreeNode;

public class S0783MinimumDistanceBetweenBSTNodes {
    private int diff = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        travel(root);
        return diff;
    }

    private int[] travel(TreeNode root) {
        int min = root.val, max = root.val;
        if (root.left != null) {
            int[] left = travel(root.left);
            int d = root.val-left[1];
            if (d < diff) {
                diff = d;
            }
            min = left[0];
        }
        if (root.right != null) {
            int[] right = travel(root.right);
            int d = right[0]-root.val;
            if (d < diff) {
                diff = d;
            }
            max = right[1];
        }
        return new int[] {min, max};
    }
}
