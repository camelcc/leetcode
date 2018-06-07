import java.util.Stack;

public class S0234PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //TODO: O(n) time, O(1) space
    public boolean isPalindrome(ListNode head) {
        ListNode origin = head;

        Stack<ListNode> reverse = new Stack<>();
        while (head != null) {
            reverse.add(head);
            head = head.next;
        }
        while (!reverse.isEmpty()) {
            if (reverse.pop().val != origin.val) {
                return false;
            }
            origin = origin.next;
        }
        return true;
    }
}
