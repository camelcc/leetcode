import java.util.Comparator;
import java.util.PriorityQueue;

public class S0023MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode l : lists) {
            if (l != null) {
                queue.add(l);
            }
        }
        ListNode res = new ListNode(0);
        ListNode tail = res;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            tail.next = min;
            min = min.next;
            if (min != null) {
                queue.add(min);
            }
            tail = tail.next;
        }

        return res.next;
    }
}
