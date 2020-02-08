import util.ListNode;

public class S0143ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = slow.next;
        slow.next = null;

        ListNode n = right == null ? null : right.next;
        right.next = null;
        while (n != null) {
            ListNode t = n.next;
            n.next = right;
            right = n;
            n = t;
        }

        ListNode tail = new ListNode(0);
        ListNode l = head, r = right;
        while (l != null) {
            ListNode nl = l.next;
            tail.next = l;
            tail = tail.next;
            l = nl;
            if (r != null) {
                ListNode nr = r.next;
                tail.next = r;
                tail = tail.next;
                r = nr;
            }
        }
    }
}
