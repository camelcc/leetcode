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
        TreeNode pre = null;
        TreeNode first = null, second = null;

        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode t = current.left;
                while (t.right != null && t.right != current) {
                    t = t.right;
                }
                if (t.right != null) {
                    // visit current
                    if (pre != null && pre.val > current.val) {
                        if (first == null) {
                            first = pre;
                            second = current;
                        } else {
                            second = current;
                        }
                    }
                    pre = current;

                    current = current.right;
                    t.right = null;
                } else {
                    t.right = current;
                    current = current.left;
                }
            } else {
                // visit current
                if (pre != null && pre.val > current.val) {
                    if (first == null) {
                        first = pre;
                        second = current;
                    } else {
                        second = current;
                    }
                }
                pre = current;

                current = current.right;
            }
        }
        // swap
        if (first != null && second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}
