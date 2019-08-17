import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S0103BTZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> value = new ArrayList<>();
            List<TreeNode> leaf = new LinkedList<>();
            for (TreeNode node : queue) {
                if (level % 2 == 0) {
                    value.add(node.val);
                } else {
                    value.add(0, node.val);
                }
                if (node.left != null) {
                    leaf.add(node.left);
                }
                if (node.right != null) {
                    leaf.add(node.right);
                }
            }
            queue = leaf;
            res.add(value);
            level++;
        }
        return res;
    }
}
