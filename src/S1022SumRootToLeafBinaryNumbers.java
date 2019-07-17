public class S1022SumRootToLeafBinaryNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int val) {
        assert root != null;
        int v = (val<<1)+root.val;
        if (root.left == null && root.right == null) {
            return v;
        } else if (root.left == null) {
            return sum(root.right, v);
        } else if (root.right == null) {
            return sum(root.left, v);
        } else {
            return sum(root.left, v)+sum(root.right, v);
        }
    }
}
