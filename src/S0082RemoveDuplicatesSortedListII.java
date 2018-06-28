public class S0082RemoveDuplicatesSortedListII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode res = null;
        ListNode tail = null;

        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            int count = 1;
            while (next != null && current.val == next.val) {
                count++;
                next = next.next;
            }
            if (count < 2) {
                if (tail == null) {
                    res = current;
                    tail = current;
                } else {
                    tail.next = current;
                    tail = tail.next;
                }
            }

            current = next;
        }
        if (tail != null) {
            tail.next = null;
        }

        return res;
    }
}
