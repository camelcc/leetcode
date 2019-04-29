public class S0099RecoverBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        int mid = root.val;
        TreeNode l = invalid(root.left, mid, true);
        TreeNode r = invalid(root.right, mid, false);
        if (l == null && r == null) {
            recoverTree(root.left);
            recoverTree(root.right);
        } else if (l != null && r == null) {
            root.val = l.val;
            l.val = mid;
        } else if (l == null && r != null) {
            root.val = r.val;
            r.val = mid;
        } else {
            int t = l.val;
            l.val = r.val;
            r.val = t;
        }
    }

    private TreeNode invalid(TreeNode root, int val, boolean left) {
        if (root == null) {
            return null;
        }

        TreeNode res = null;
        if ((left && root.val > val) || (!left && root.val < val)) {
            res = root;
        }
        TreeNode t = invalid(root.left, val, left);
        if (t != null) {
            if (res == null) {
                res = t;
            } else {
                if ((left && res.val < t.val) || (!left && res.val > t.val)) {
                    res = t;
                }
            }
        }
        t = invalid(root.right, val, left);
        if (t != null) {
            if (res == null) {
                res = t;
            } else {
                if ((left && res.val < t.val) || (!left && res.val > t.val)) {
                    res = t;
                }
            }
        }
        return res;
    }
}
