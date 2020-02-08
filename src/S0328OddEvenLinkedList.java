import util.ListNode;

public class S0328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;

        ListNode n = head;
        while (n != null) {
            ListNode odd = n;
            ListNode even = n.next;
            if (oddHead == null) {
                oddHead = odd;
                oddTail = odd;
            } else {
                oddTail.next = odd;
                oddTail = oddTail.next;
            }
            if (evenHead == null) {
                evenHead = even;
                evenTail = even;
            } else {
                evenTail.next = even;
                evenTail = evenTail.next;
            }
            if (even != null) {
                n = even.next;
            } else {
                break;
            }
        }
        oddTail.next = evenHead;
        if (evenTail != null) {
            evenTail.next = null;
        }

        return head;
    }
}
