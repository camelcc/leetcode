public class S0086PartitionList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode lessHead = null;
        ListNode less = null;
        ListNode bigHead = null;
        ListNode big = null;

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                if (less == null) {
                    less = current;
                    lessHead = current;
                } else {
                    less.next = current;
                    less = less.next;
                }
            } else {
                if (big == null) {
                    big = current;
                    bigHead = current;
                } else {
                    big.next = current;
                    big = big.next;
                }
            }
            current = current.next;
        }
        if (less != null) {
            less.next = bigHead;
        }
        if (big != null) {
            big.next = null;
        }

        if (lessHead != null) {
            return lessHead;
        }
        return bigHead;
    }
}
