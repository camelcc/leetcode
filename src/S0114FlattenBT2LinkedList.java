public class S0114FlattenBT2LinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left != null) {
            flatten(left);
            TreeNode last = left;
            while (last.right != null) {
                last = last.right;
            }
            last.right = right;
            root.right = left;
            root.left = null;
        }
        if (right != null) {
            flatten(right);
        }
    }
}
