import util.TreeNode;

public class S0993CousinsBinaryTree {
    private int dx = -1, dy = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (x == y) {
            return false;
        }
        if (!search(root, x, y, 1)) {
            return false;
        }
        return dx == dy;
    }

    private boolean search(TreeNode root, int x, int y, int d) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null &&
                ((root.left.val == x && root.right.val == y) ||
                        (root.left.val == y && root.right.val == x))) {
            return false;
        }

        if (root.val == x) {
            dx = d;
        } else if (root.val == y) {
            dy = d;
        }
        if (dx != -1 && dy != -1) {
            return true;
        }
        if (!search(root.left, x, y, d+1)) {
            return false;
        }
        return search(root.right, x, y, d+1);
    }
}
