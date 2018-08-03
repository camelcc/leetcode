public class S0230KthBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        int left = size(root.left);
        if (k == left+1) {
            return root.val;
        } else if (k <= left) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k-left-1);
        }
    }

    private int size(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null) {
            return 1 + size(node.right);
        }
        if (node.right == null) {
            return 1 + size(node.left);
        }

        return 1 + size(node.left) + size(node.right);
    }
}
