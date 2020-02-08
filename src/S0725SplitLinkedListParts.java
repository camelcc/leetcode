import util.ListNode;

public class S0725SplitLinkedListParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (k == 0) {
            return null;
        }
        ListNode[] heads = new ListNode[k];
        ListNode[] tails = new ListNode[k];
        int[] count = new int[k];
        if (k == 1) {
            heads[0] = root;
            return heads;
        }

        ListNode node = root;
        while (node != null) {
            add(heads, tails, count, new ListNode(node.val));
            node = node.next;
        }

        return heads;
    }

    private void add(ListNode[] heads, ListNode[] tails, int[] cnt, ListNode node) {
        int N = heads.length;
        if (heads[N-1] == null) {
            heads[N-1] = node;
            tails[N-1] = node;
        } else {
            tails[N-1].next = node;
            tails[N-1] = node;
        }
        cnt[N-1]++;

        for (int i = N-1; i > 0 && cnt[i] > cnt[i-1]; i--) {
            ListNode t = heads[i];
            if (heads[i] == tails[i]) { // last
                heads[i] = null;
                tails[i] = null;
            } else {
                heads[i] = heads[i].next;
            }
            t.next = null;
            cnt[i]--;

            if (heads[i-1] == null) {
                heads[i-1] = t;
                tails[i-1] = t;
            } else {
                tails[i-1].next = t;
                tails[i-1] = t;
            }
            cnt[i-1]++;
        }
    }
}
