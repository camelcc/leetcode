public class S0116PopulatingNextRightPointers {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        assert root.left != null;
        assert root.right != null;

        TreeLinkNode l = root.left;
        TreeLinkNode r = root.right;
        while (l != null) {
            assert r != null;

            l.next = r;

            l = l.right;
            r = r.left;
        }

        connect(root.left);
        connect(root.right);
    }
}
