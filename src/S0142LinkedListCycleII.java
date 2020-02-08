import util.ListNode;

public class S0142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
            fast = fast == null ? null : fast.next;
        }
        if (fast == null) {
            return null;
        }
        if (slow.next == slow) {
            return slow;
        }
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
