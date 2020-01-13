public class S1315SumNodesEvenValuedGrandparent {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null) {
            res += sum(root.left.left, root.left.val, root.val);
            res += sum(root.left.right, root.left.val, root.val);
        }
        if (root.right != null) {
            res += sum(root.right.left, root.right.val, root.val);
            res += sum(root.right.right, root.right.val, root.val);
        }
        return res;
    }

    private int sum(TreeNode node, int parent, int grand) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        sum += sum(node.left, node.val, parent);
        sum += grand%2 == 0 ? node.val: 0;
        sum += sum(node.right, node.val, parent);
        return sum;
    }
}
