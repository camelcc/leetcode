import java.util.ArrayList;
import java.util.List;

public class S1161MaximumLevelSumBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1, sum = root.val, depth = 1;
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            depth++;
            int s = 0;
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : level) {
                if (node.left != null) {
                    s += node.left.val;
                    next.add(node.left);
                }
                if (node.right != null) {
                    s += node.right.val;
                    next.add(node.right);
                }
            }
            if (s > sum) {
                res = depth;
                sum = s;
            }
            level = next;
        }
        return res;
    }
}
