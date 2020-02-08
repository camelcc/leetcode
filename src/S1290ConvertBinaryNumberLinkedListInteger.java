import util.ListNode;

public class S1290ConvertBinaryNumberLinkedListInteger {
    public int getDecimalValue(ListNode head) {
        int res = 0;

        while (head != null) {
            res = (res<<1) + head.val;
            head = head.next;
        }
        return res;
    }
}
