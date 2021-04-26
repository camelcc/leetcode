import util.ListNode;

public class S1669MergeBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre = list1;
        int i = 1;
        while (i < a) {
            pre = pre.next;
            i++;
        }
        ListNode post = pre;
        while (i < b) {
            post = post.next;
            i++;
        }
        post = post.next.next;

        pre.next = list2;
        ListNode m = list2;
        while (m.next != null) {
            m = m.next;
        }
        m.next = post;
        return list1;
    }
}
