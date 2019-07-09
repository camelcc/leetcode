import java.util.ArrayList;
import java.util.List;

public class S0971FlipBinaryTreeToMatchPreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        int r = match(root, voyage, 0, res);
        if (r != -1) {
            return res;
        } else {
            res.clear();
            res.add(-1);
            return res;
        }
    }

    private int match(TreeNode root, int[] voyage, int pos, List<Integer> flipped) {
        if (root.val != voyage[pos]) {
            return -1;
        }
        pos++;
        if (root.left == null && root.right == null) {
            return pos;
        } else if (root.left == null) {
            return match(root.right, voyage, pos, flipped);
        } else if (root.right == null) {
            return match(root.left, voyage, pos, flipped);
        } else { // left != null && right != null
            if (root.left.val == voyage[pos]) {
                pos = match(root.left, voyage, pos, flipped);
                if (pos == -1) {
                    return -1;
                }
                return match(root.right, voyage, pos, flipped);
            } else if (root.right.val == voyage[pos]) {
                flipped.add(root.val);
                pos = match(root.right, voyage, pos, flipped);
                if (pos == -1) {
                    return -1;
                }
                return match(root.left, voyage, pos, flipped);
            } else {
                return -1;
            }
        }
    }
}

