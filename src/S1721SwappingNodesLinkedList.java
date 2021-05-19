import util.ListNode;

import java.util.LinkedList;

public class S1721SwappingNodesLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        LinkedList<ListNode> list = new LinkedList<>();
        int p = 1;
        ListNode c = head;
        ListNode first = null, second = null;
        while (c != null) {
            if (p == k) {
                first = c;
            }
            if (list.size() == k) {
                list.poll();
            }
            list.offer(c);
            c = c.next;
            p++;
        }
        second = list.poll();
        assert first != null;
        int t = first.val;
        assert second != null;
        first.val = second.val;
        second.val = t;
        return head;
    }
}
