import util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S1019NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> res = new ArrayList<>();
        Stack<int[]> prev = new Stack<>();
        int p = 0;
        while (head != null) {
            while (!prev.isEmpty() && prev.peek()[1] < head.val) {
                int[] t = prev.pop();
                res.set(t[0], head.val);
            }
            prev.push(new int[]{p, head.val});
            res.add(0);
            p++;
            head = head.next;
        }

        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
