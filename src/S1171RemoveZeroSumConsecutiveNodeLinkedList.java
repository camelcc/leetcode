import util.ListNode;

import java.util.*;

public class S1171RemoveZeroSumConsecutiveNodeLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        HashMap<Integer, ListNode> preSum = new HashMap<>();
        ListNode prev = dummy, current = head;
        while (current != null) {
            if (current.val == 0) {
                prev.next = current.next;
                current = current.next;
                continue;
            }
            assert !preSum.containsKey(0);
            if (preSum.containsKey(-current.val)) {
                ListNode n = preSum.get(-current.val);
                n.next = current.next;
                return removeZeroSumSublists(dummy.next);
            }

            HashMap<Integer, ListNode> next = new HashMap<>();
            for (int k : preSum.keySet()) {
                next.put(k+current.val, preSum.get(k));
            }
            next.put(current.val, prev);
            preSum = next;
            prev = current;
            current = current.next;
        }

        return dummy.next;
    }
}
