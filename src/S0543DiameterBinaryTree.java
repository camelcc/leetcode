import util.TreeNode;

public class S0543DiameterBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        inorder(root);
        return diameter;
    }

    private int inorder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = inorder(node.left);
        int r = inorder(node.right);
        if (l+r > diameter) {
            diameter = l+r;
        }
        return Math.max(l, r)+1;
    }
}
