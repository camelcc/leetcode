public class S0021MergeSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode tail = null;

        ListNode l1Node = l1;
        ListNode l2Node = l2;
        while (l1Node != null && l2Node != null) {
            if (l1Node.val > l2Node.val) {
                if (head == null) {
                    head = l2Node;
                    tail = head;
                } else {
                    tail.next = l2Node;
                    tail = l2Node;
                }
                l2Node = l2Node.next;
            } else {
                if (head == null) {
                    head = l1Node;
                    tail = head;
                } else {
                    tail.next = l1Node;
                    tail = l1Node;
                }
                l1Node = l1Node.next;
            }
        }

        tail.next = l1Node == null ? l2Node : l1Node;
        return head;
    }
}
