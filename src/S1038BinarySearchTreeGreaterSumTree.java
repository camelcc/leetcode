import util.TreeNode;

public class S1038BinarySearchTreeGreaterSumTree {
    public TreeNode bstToGst(TreeNode root) {
        travel(root, 0);
        return root;
    }

    private int travel(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        int s = sum;
        if (root.right != null) {
            s = travel(root.right, sum);
        }
        s += root.val;
        root.val = s;
        if (root.left != null) {
            s = travel(root.left, s);
        }
        return s;
    }
}
