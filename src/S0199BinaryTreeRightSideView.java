import java.util.ArrayList;
import java.util.List;

public class S0199BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            TreeNode last = level.get(level.size()-1);
            res.add(last.val);

            List<TreeNode> next = new ArrayList<>();
            for (TreeNode n : level) {
                if (n.left != null) {
                    next.add(n.left);
                }
                if (n.right != null) {
                    next.add(n.right);
                }
            }
            level = next;
        }
        return res;
    }
}
