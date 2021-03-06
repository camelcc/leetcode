import util.TreeNode;

public class S0572SubtreeAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null && t != null) {
            return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return false;
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null && t != null) {
            return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
        }
        return false;
    }
}
