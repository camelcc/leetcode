import java.util.Stack;

import util.ListNode;

public class S2074ReverseNodesEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int len = 2;
        ListNode pre = head;
        ListNode current = head.next;
        while (current != null) {
            // tail.next = current;
            int i = 0;
            Stack<ListNode> stack = new Stack<>();
            while (i < len && current != null) {
                stack.push(current);
                current = current.next;
                i++;
            }
            if (stack.size()%2 != 0) {
                pre = stack.pop();
                len++;
                continue;
            }
            // reverse
            while (!stack.isEmpty()) {
                pre.next = stack.pop();
                pre = pre.next;
            }
            pre.next = current;
            len++;
        }
        return head;
    }
}
