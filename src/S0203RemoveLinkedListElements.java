public class S0203RemoveLinkedListElements {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode h = head;
        while (h != null && h.val == val) {
            h = h.next;
        }
        if (h == null) {
            return null;
        }

        ListNode p = h, c = p.next;
        while (c != null) {
            if (c.val == val) {
                p.next = c.next;
            } else {
                p = c;
            }
            c = c.next;
        }

        return h;
    }
}
