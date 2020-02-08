import util.TreeNode;

public class S0623AddOneRowTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode res = new TreeNode(v);
            res.left = root;
            return res;
        }

        if (root == null) {
            return null;
        }

        if (d == 2) {
            TreeNode l = root.left;
            TreeNode r = root.right;
            root.left = new TreeNode(v);
            root.left.left = l;
            root.right = new TreeNode(v);
            root.right.right = r;
            return root;
        }

        root.left = addOneRow(root.left, v, d-1);
        root.right = addOneRow(root.right, v, d-1);

        return root;
    }
}
