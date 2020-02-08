import util.ListNode;

public class S0002AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode((l1.val + l2.val)%10);
        int r = (l1.val + l2.val)/10;
        ListNode sum = head;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            int s = r;
            if (l1 != null) {
                s += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                s += l2.val;
                l2 = l2.next;
            }
            sum.next = new ListNode(s%10);
            sum = sum.next;
            r = s/10;
        }
        if (r != 0) {
            sum.next = new ListNode(r);
        }

        return head;
    }
}
