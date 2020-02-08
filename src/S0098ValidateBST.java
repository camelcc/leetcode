import util.TreeNode;

public class S0098ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return valid(root) != null;
    }

    private int[] valid(TreeNode root) {
        assert root != null;
        int min = root.val, max = root.val;
        if (root.left != null) {
            int[] l = valid(root.left);
            if (l == null || root.val <= l[1]) {
                return null;
            }
            min = l[0];
        }
        if (root.right != null) {
            int[] r = valid(root.right);
            if (r == null || root.val >= r[0]) {
                return null;
            }
            max = r[1];
        }
        return new int[]{min, max};
    }
}
