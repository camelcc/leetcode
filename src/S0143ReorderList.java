public class S0143ReorderList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode h = head;
        while (h != null && h.next != null) {
            h.next = reverseLast(h.next);
            h = h.next.next;
        }
    }

    private ListNode reverseLast(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        while (last.next.next != null) {
            last = last.next;
        }

        ListNode h = last.next;
        last.next = null;
        h.next = head;
        return h;
    }
}
