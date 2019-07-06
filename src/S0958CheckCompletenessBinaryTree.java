import java.util.LinkedList;
import java.util.Queue;

public class S0958CheckCompletenessBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> level = new LinkedList<>();
        level.offer(root);
        boolean leaf = false;
        while (!level.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<>();
            while (!level.isEmpty()) {
                TreeNode n = level.poll();
                if (leaf) {
                    if (n.left == null && n.right == null) {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    if (n.left == null) {
                        if (n.right != null) {
                            return false;
                        }
                        leaf = true;
                    } else if (n.right == null) {
                        // n.left != null
                        next.offer(n.left);
                        leaf = true;
                    } else {
                        next.offer(n.left);
                        next.offer(n.right);
                    }
                }
            }
            level = next;
        }
        return true;
    }
}
