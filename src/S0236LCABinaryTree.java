import java.util.Stack;

public class S0236LCABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pPath = new Stack<>();
        contains(root, p, pPath);
        Stack<TreeNode> qPath = new Stack<>();
        contains(root, q, qPath);

        int commonSize = Math.min(pPath.size(), qPath.size());
        while (pPath.size() > commonSize) {
            pPath.pop();
        }
        while (qPath.size() > commonSize) {
            qPath.pop();
        }

        while (!pPath.isEmpty() && !qPath.isEmpty()) {
            TreeNode pn = pPath.pop();
            TreeNode qn = qPath.pop();
            if (pn == qn) {
                return pn;
            }
        }
        return null;
    }

    private boolean contains(TreeNode root, TreeNode p, Stack<TreeNode> path) {
        path.push(root);
        if (root.val == p.val) {
            return true;
        }

        if (root.left != null && contains(root.left, p, path)) {
            return true;
        }
        if (root.right != null && contains(root.right, p, path)) {
            return true;
        }

        path.pop();
        return false;
    }
}
