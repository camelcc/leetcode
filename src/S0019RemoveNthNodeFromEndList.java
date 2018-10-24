public class S0019RemoveNthNodeFromEndList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = null;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            if (slow == null) {
                slow = head;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        if (slow == null) {
            return head.next;
        } else {
            slow.next = slow.next.next;
            return head;
        }
    }
}
