public class S0117PopulatingNextRightPointersII {
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
        if (root.left == null) {
            connect(root.right);
            return;
        }
        if (root.right == null) {
            connect(root.left);
            return;
        }

        int level = 0;
        TreeLinkNode l = root.left;
        TreeLinkNode r = root.right;
        while (l != null && r != null) {
            l.next = r;
            level++;

            l = max(root.left, level);
            r = min(root.right, level);
        }

        connect(root.left);
        connect(root.right);
    }

    private TreeLinkNode max(TreeLinkNode root, int level) {
        if (level == 0) {
            return root;
        }
        if (root == null) {
            return null;
        }

        if (level == 1) {
            return root.right == null ? root.left : root.right;
        }

        TreeLinkNode right = max(root.right, level-1);
        if (right != null) {
            return right;
        }
        return max(root.left, level-1);
    }

    private TreeLinkNode min(TreeLinkNode root, int level) {
        if (level == 0) {
            return root;
        }
        if (root == null) {
            return null;
        }

        if (level == 1) {
            return root.left == null ? root.right : root.left;
        }

        TreeLinkNode left = min(root.left, level-1);
        if (left != null) {
            return left;
        }
        return min(root.right, level-1);
    }
}
