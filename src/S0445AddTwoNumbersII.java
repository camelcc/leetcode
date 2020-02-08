import util.ListNode;

import java.util.Stack;

public class S0445AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> sum = new Stack<>();
        Stack<ListNode> l1Stack = new Stack<>();
        while (l1 != null) {
            l1Stack.push(l1);
            l1 = l1.next;
        }
        Stack<ListNode> l2Stack = new Stack<>();
        while (l2 != null) {
            l2Stack.push(l2);
            l2 = l2.next;
        }

        int c = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
            int l1Val = l1Stack.isEmpty() ? 0 : l1Stack.pop().val;
            int l2Val = l2Stack.isEmpty() ? 0 : l2Stack.pop().val;

            int s = c + l1Val + l2Val;
            c = s / 10;
            sum.push(new ListNode(s%10));
        }
        if (c != 0) {
            sum.push(new ListNode(c));
        }

        ListNode res = sum.pop();
        ListNode node = res;
        while (!sum.isEmpty()) {
            node.next = sum.pop();
            node = node.next;
        }
        return res;
    }
}
