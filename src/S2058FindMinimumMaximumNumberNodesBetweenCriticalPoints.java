import util.ListNode;

public class S2058FindMinimumMaximumNumberNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int max = -1, min = Integer.MAX_VALUE;
        int pre = head.val, cur = head.next.val;
        int first = -1, last = -1, pos = 1;
        ListNode post = head.next.next;
        while (post != null) {
            if ((pre < cur && cur > post.val) || (pre > cur && cur < post.val)) {
                if (first == -1) {
                    first = pos;
                } else {
                    max = pos-first;
                }
                if (last == -1) {
                    last = pos;
                } else {
                    min = Math.min(min, pos-last);
                }
                last = pos;
            }
            pos++;
            pre = cur;
            cur = post.val;
            post = post.next;
        }
        if (max == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{min, max};
    }
}
