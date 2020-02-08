import util.ListNode;

public class S0082RemoveDuplicatesSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = null, last = null, current = head;
        while (current != null) {
            if (current.next == null || current.val != current.next.val) {
                if (res == null) {
                    res = current;
                    last = res;
                } else {
                    last.next = current;
                    last = current;
                }
                current = current.next;
            } else {
                int v = current.val;
                while (current != null && current.val == v) {
                    current = current.next;
                }
            }
        }
        if (last != null) {
            last.next = null;
        }
        return res;
    }
}
