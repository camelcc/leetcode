public class S0114FlattenBT2LinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode flatten(TreeNode root) {
        return flatten(root, null);
    }

    private TreeNode flatten(TreeNode root, TreeNode pre) {
        if (root == null) {
            return pre;
        }
        pre = flatten(root.right, pre);
        pre = flatten(root.left, pre);
        root.right = pre;
        root.left = null;
        return pre;
    }
}
