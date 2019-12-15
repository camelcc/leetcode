public class S1290ConvertBinaryNumberLinkedListInteger {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        int res = 0;

        while (head != null) {
            res = (res<<1) + head.val;
            head = head.next;
        }
        return res;
    }
}
