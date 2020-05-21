import util.TreeNode;

public class S1448CountGoodNodesBinaryTree {
    public int goodNodes(TreeNode root) {
        return traverse(root, Integer.MIN_VALUE);
    }

    private int traverse(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }

        int res = 0;
        int v = Math.max(max, node.val);
        if (v <= node.val) {
            res = 1;
        }
        res += traverse(node.left, v);
        res += traverse(node.right, v);
        return res;
    }
}
