import util.ListNode;
import util.TreeNode;

import java.util.LinkedList;

public class S1367LinkedListBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return travel(root, head, new LinkedList<>());
    }

    private boolean travel(TreeNode root, ListNode head, LinkedList<ListNode> candidates) {
        if (root == null) {
            return false;
        }

        LinkedList<ListNode> next = new LinkedList<>();
        if (root.val == head.val) {
            if (head.next == null) {
                return true;
            }
            next.offer(head.next);
        }
        for (ListNode c : candidates) {
            if (c.val == root.val) {
                if (c.next == null) {
                    return true;
                } else {
                    next.offer(c.next);
                }
            }
        }

        return travel(root.left, head, next) || travel(root.right, head, next);
    }
}
