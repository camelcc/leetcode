public class S0023MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, tail = null;
        boolean exist = true;
        while (exist) {
            exist = false;

            int min = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }

                if (min == -1 || lists[i].val < lists[min].val) {
                    exist = true;
                    min = i;
                }
            }

            if (exist) {
                if (head == null) {
                    head = lists[min];
                    tail = lists[min];
                } else {
                    tail.next = lists[min];
                    tail = tail.next;
                }

                lists[min] = lists[min].next;
            }
        }
        return head;
    }
}
