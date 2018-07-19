public class S0147InsertionSortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode next = head.next;
        ListNode res = null;
        while (next != null) {
            res = insert(res, current);
            current = next;
            next = next.next;
        }
        res = insert(res, current);
        return res;
    }

    private ListNode insert(ListNode list, ListNode node) {
        node.next = null;

        if (list == null) {
            return node;
        }
        if (list.val >= node.val) {
            node.next = list;
            return node;
        }

        ListNode n = list;
        while (n.next != null && n.next.val < node.val) {
            n = n.next;
        }

        node.next = n.next;
        n.next = node;
        return list;
    }
}
