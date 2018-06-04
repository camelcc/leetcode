import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class S0110BalancedBTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> upLevel = new ArrayList<>();
        upLevel.add(root);
        Stack<TreeNode> heights = new Stack<>();
        heights.push(root);

        while (!upLevel.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();
            for (TreeNode n : upLevel) {
                if (n.left != null) {
                    heights.push(n.left);
                    level.add(n.left);
                }
                if (n.right != null) {
                    heights.push(n.right);
                    level.add(n.right);
                }
            }
            upLevel = level;
        }

        HashMap<TreeNode, Integer> h = new HashMap<>();
        while (!heights.isEmpty()) {
            TreeNode node = heights.pop();
            int l = node.left == null ? 0 : h.get(node.left);
            int r = node.right == null ? 0 : h.get(node.right);
            if (Math.abs(l - r) > 1) {
                return false;
            }
            h.put(node, 1 + Math.max(l, r));
        }
        return true;
    }
}
