import java.util.ArrayList;
import java.util.List;

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
        List<TreeNode> pPath = new ArrayList<>();
        pPath.add(root);


        List<TreeNode> qPath = new ArrayList<>();
        pPath.add(root);
        if (root.val == p.val) {
        } else {

        }

        TreeNode res = root;
        while (!pPath.isEmpty() && !qPath.isEmpty()) {
            TreeNode pn = pPath.remove(0);
            TreeNode qn = qPath.remove(0);
            if (pn == qn) {
                res = pn;
            } else {
                break;
            }
        }
        return res;
    }

    private boolean contains(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }

        if (root.val == p.val) {
            return true;
        }
        return contains(root.left, p) || contains(root.right, p);
    }
}
