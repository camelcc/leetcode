public class S0138CopyListRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode res = new RandomListNode(head.label);

        // copy next
        RandomListNode h = head;
        RandomListNode r = res;
        while (h.next != null) {
            r.next = new RandomListNode(h.next.label);
            h = h.next;
            r = r.next;
        }

        // copy random
        h = head;
        r = res;
        while (h != null) {
            if (h.random == null) {
                r.random = null;
            } else {
                int step = 0;
                RandomListNode old = head;
                while (old != null && h.random != old) {
                    old = old.next;
                    step++;
                }

                RandomListNode search = res;
                for (int i = 0; i < step; i++) {
                    search = search.next;
                }

                r.random = search;
            }
            h = h.next;
            r = r.next;
        }
        return res;
    }
}
