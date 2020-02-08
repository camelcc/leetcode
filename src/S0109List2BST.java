import util.ListNode;
import util.TreeNode;

public class S0109List2BST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return bst(head, null);
    }

    private TreeNode bst(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode res = new TreeNode(slow.val);
        res.left = bst(head, slow);
        res.right = bst(slow.next, tail);
        return res;
    }
}
