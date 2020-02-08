import util.ListNode;

public class S0025ReverseNodesKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k <= 1) {
            return head;
        }

        int len = 0;
        ListNode n = head;
        while (n != null && len < k) {
            len++;
            n = n.next;
        }
        if (len < k) {
            return head;
        }
        ListNode tail = reverseKGroup(n, k);
        n = head;
        ListNode h = n;

        int cnt = 0;
        while (cnt < k) {
            h = n.next;
            n.next = tail;
            tail = n;
            n = h;
            cnt++;
        }
        return tail;
    }
}
