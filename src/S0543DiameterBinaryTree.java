public class S0543DiameterBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

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
