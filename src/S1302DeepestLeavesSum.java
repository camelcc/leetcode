import util.TreeNode;

public class S1302DeepestLeavesSum {
    int deepestLevel = 0, sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sum(root, 0);
        return sum;
    }

    private void sum(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (depth == deepestLevel) {
                sum += node.val;
            } else if (depth > deepestLevel) {
                deepestLevel = depth;
                sum = node.val;
            }
            return;
        }

        if (node.left != null) {
            sum(node.left, depth+1);
        }
        if (node.right != null) {
            sum(node.right, depth+1);
        }
    }
}
