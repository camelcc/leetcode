import util.TreeNode;

public class S1372LongestZigZagPathBinaryTree {
    public int longestZigZag(TreeNode root) {
        int l = longest(root, true, 0), r = longest(root, false, 0);
        return Math.max(l, r)-1;
    }

    private int longest(TreeNode root, boolean left, int len) {
        if (root == null) {
            return len;
        }
        if (root.left == null && root.right == null) {
            return len+1;
        }

        int l = longest(root.left, true, left ? 1 : len+1);
        int r = longest(root.right, false, left ? len+1 : 1);
        return Math.max(l, r);
    }
}
