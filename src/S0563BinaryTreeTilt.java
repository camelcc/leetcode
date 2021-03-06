import util.TreeNode;

public class S0563BinaryTreeTilt {
    private int sum = 0;

    public int findTilt(TreeNode root) {
        sum = 0;
        post(root);
        return sum;
    }

    private int post(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = post(root.left);
        int r = post(root.right);
        sum += Math.abs(l-r);
        return l+r+root.val;
    }
}
