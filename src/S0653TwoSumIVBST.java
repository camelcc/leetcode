public class S0653TwoSumIVBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return travel(root, root, k);
    }

    private boolean travel(TreeNode node, TreeNode root, int k) {
        if (node == null) {
            return false;
        }
        TreeNode find = find(root, k-node.val);
        if (find != null && find != node) {
            return true;
        }
        return travel(node.left, root, k) || travel(node.right, root, k);
    }

    private TreeNode find(TreeNode root, int v) {
        if (root == null) {
            return null;
        }
        if (root.val == v) {
            return root;
        } else if (root.val > v) {
            return find(root.left, v);
        } else {
            return find(root.right, v);
        }
    }
}
