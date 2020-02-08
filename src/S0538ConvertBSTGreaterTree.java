import util.TreeNode;

public class S0538ConvertBSTGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        postSum(root, 0);
        return root;
    }

    private int postSum(TreeNode node, int baseSum) {
        if (node == null) {
            return baseSum;
        }
        int greater = postSum(node.right, baseSum);
        node.val += greater;
        return postSum(node.left, node.val);
    }
}
