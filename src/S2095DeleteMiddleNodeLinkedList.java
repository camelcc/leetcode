import util.ListNode;

public class S2095DeleteMiddleNodeLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return head;
    }
}
