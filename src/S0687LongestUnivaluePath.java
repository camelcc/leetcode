import util.TreeNode;

public class S0687LongestUnivaluePath {
    int len = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longest(root);
        return len;
    }

    private int longest(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        if (root.left != null && root.left.val == root.val) {
            left = 1+longest(root.left);
        } else {
            longest(root.left);
        }
        int right = 0;
        if (root.right != null && root.right.val == root.val) {
            right = 1+longest(root.right);
        } else {
            longest(root.right);
        }
        len = Math.max(len, left+right);
        return Math.max(left, right);
    }
}
