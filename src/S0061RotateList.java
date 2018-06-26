public class S0061RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int len = 0;
        ListNode h = head;
        while (h != null) {
            len++;
            h = h.next;
        }
        if (len == 1) {
            return head;
        }

        k = k % len;
        if (k == 0) {
            return head;
        }

        h = head;
        int p = 0;
        while (p < len-k-1) {
            h = h.next;
            p++;
        }

        ListNode nh = h.next;
        h.next = null;

        ListNode t = nh;
        while (t.next != null) {
            t = t.next;
        }
        t.next = head;
        return nh;
    }
}
