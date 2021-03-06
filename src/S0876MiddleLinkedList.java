import util.ListNode;

public class S0876MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        int cnt = 0;
        ListNode n = head;
        while (n != null) {
            cnt++;
            n = n.next;
        }
        cnt = cnt/2;
        while (cnt > 0) {
            head = head.next;
            cnt--;
        }
        return head;
    }
}
