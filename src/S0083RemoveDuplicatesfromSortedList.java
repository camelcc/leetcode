import util.ListNode;

public class S0083RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode tail = head;
        ListNode current = head.next;
        while (current != null) {
            if (tail.val != current.val) {
                tail.next = current;
                tail = tail.next;
            }
            current = current.next;
        }
        tail.next = null;
        return head;
    }
}
