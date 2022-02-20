import util.ListNode;

public class S2181MergeNodesBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode tail = res;

        ListNode current = head.next;
        int value = 0;
        while (current != null) {
            if (current.val == 0) {
                tail.next = new ListNode(value);
                value = 0;
                tail = tail.next;
            } else {
                value = value + current.val;
            }

            current = current.next;
        }

        return res.next;
    }
}
