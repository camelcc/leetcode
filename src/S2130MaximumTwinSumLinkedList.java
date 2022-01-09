import java.util.Stack;

import util.ListNode;

public class S2130MaximumTwinSumLinkedList {
    public int pairSum(ListNode head) {
        int len = 0;
        ListNode node = head;
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
            len++;
        }
        int res = 0;
        node = head;
        for (int i = 0; i < len/2; i++) {
            ListNode tail = stack.pop();
            res = Math.max(res, tail.val + node.val);
            node = node.next;
        }
        return res;
    }
}
