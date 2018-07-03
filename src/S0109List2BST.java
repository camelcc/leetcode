public class S0109List2BST {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        int len = 0;
        ListNode n = head;
        while (n != null) {
            len++;
            n = n.next;
        }
        int mid = len/2;

        ListNode midNode = head;
        for (int i = 1; i < mid; i++) {
            midNode = midNode.next;
        }
        ListNode t = midNode;
        midNode = midNode.next;
        t.next = null;

        TreeNode root = new TreeNode(midNode.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(midNode.next);
        return root;
    }
}
