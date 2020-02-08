import util.TreeNode;

public class S0235LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        if (root.val == min || root.val == max) {
            return root;
        }
        if (root.val > min && root.val < max) {
            return root;
        }
        return lowestCommonAncestor(root.val < min ? root.right : root.left, p, q);
    }
}
