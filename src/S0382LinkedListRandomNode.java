import java.util.Random;

public class S0382LinkedListRandomNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        private ListNode head;
        private Random random;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        /** Returns a random node's value. */
        public int getRandom() {
            ListNode res = head;
            ListNode n = head.next;
            int i = 1;
            while (n != null) {
                int r = random.nextInt(i+1);
                if (r == 0) {
                    res = n;
                }
                n = n.next;
                i++;
            }

            return res.val;
        }
    }
}
