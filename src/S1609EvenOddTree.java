import util.TreeNode;

import java.util.LinkedList;

public class S1609EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val%2 == 0) {
            return false;
        }

        boolean odd = true;
        LinkedList<TreeNode> current = new LinkedList<>();
        current.offer(root);
        while (!current.isEmpty()) {
            LinkedList<TreeNode> next = new LinkedList<>();
            TreeNode last = null;
            for (TreeNode n : current) {
                if (odd && n.val%2 == 0) { // increase
                    return false;
                } else if (!odd && n.val%2 == 1) { // decrease
                    return false;
                }

                if (last != null) {
                    if (odd) { // increase
                        if (n.val <= last.val) {
                            return false;
                        }
                    } else { // decrease
                        if (n.val >= last.val) {
                            return false;
                        }
                    }
                }
                if (n.left != null) {
                    next.add(n.left);
                }
                if (n.right != null) {
                    next.add(n.right);
                }
                last = n;
            }
            odd = !odd;
            current = next;
        }
        return true;
    }
}
