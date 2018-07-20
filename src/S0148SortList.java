public class S0148SortList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null || head == tail || head.next == tail) {
            return head;
        }

        ListNode start = head;
        ListNode current = head;
        while (current.next != tail) {
            if (current.next.val >= head.val) {
                current = current.next;
            } else {
                ListNode h = current.next;
                current.next = current.next.next;
                h.next = start;
                start = h;
            }
        }

        ListNode res = sortList(start, head);
        ListNode right = sortList(head.next, tail);
        head.next = right;
        return res;
    }
}
