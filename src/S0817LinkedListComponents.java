import java.util.HashSet;

public class S0817LinkedListComponents {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int numComponents(ListNode head, int[] G) {
        if (head == null || head.next == null) {
            return G.length;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }

        int cnt = 0;
        boolean section = true;
        while (head != null) {
            // connect head, head.next
            if (set.contains(head.val)) {
                if (section) {
                    cnt++;
                }
                section = false;
            } else {
                section = true;
            }
            head = head.next;
        }

        return cnt;
    }
}
