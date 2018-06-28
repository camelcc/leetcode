public class S0092ReverseLinkedListII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (m >= n) {
            return head;
        }

        ListNode res = null;

        ListNode beforeHead = null;
        ListNode beforeTail = null;

        int i = 1;
        ListNode node = head;
        while (i < m) {
            if (beforeTail == null) {
                beforeHead = node;
                beforeTail = node;
            } else {
                beforeTail.next = node;
                beforeTail = beforeTail.next;
            }
            node = node.next;
            i++;
        }

        ListNode reverseHead = null;
        ListNode reverseTail = node;
        while (i <= n) {
            if (reverseHead == null) {
                reverseHead = node;
                reverseTail = node;
                node = node.next;
            } else {
                ListNode next = node.next;
                node.next = reverseHead;
                reverseHead = node;
                node = next;
            }
            i++;
        }
        reverseTail.next = node;
        if (beforeTail != null) {
            beforeTail.next = reverseHead;
        }
        if (beforeHead != null) {
            return beforeHead;
        } else {
            return reverseHead;
        }
    }
}
