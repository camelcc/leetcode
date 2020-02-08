import util.ListNode;

public class S0234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // >= 2
        // N
        int size = 0;
        ListNode n = head;
        while (n != null) {
            size++;
            n = n.next;
        }

        ListNode p = null, c = null;
        n = head;
        int halfSize = size/2;
        do {
            p = c;
            c = n;
            n = n.next;
            c.next = p;
            halfSize--;
        } while (halfSize > 0);
        ListNode left = c, right = n;
        if (size%2 == 1) {
            p = c;
            c = n;
            n = n.next;
            left = p;
            right = n;
        }
        halfSize = size/2;
        while (halfSize > 0) {
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
            halfSize--;
        }
        return true;
    }
}
