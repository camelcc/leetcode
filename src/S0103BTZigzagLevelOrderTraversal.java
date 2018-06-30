import java.util.ArrayList;
import java.util.List;

public class S0103BTZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        boolean left2Right = true;
        while (!level.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            List<TreeNode> newLevel = new ArrayList<>();
            if (left2Right) {
                for (int i = 0; i < level.size(); i++) {
                    vals.add(level.get(i).val);
                }
            } else {
                for (int i = level.size()-1; i >= 0; i--) {
                    vals.add(level.get(i).val);
                }
            }

            for (TreeNode n : level) {
                if (n.left != null) {
                    newLevel.add(n.left);
                }
                if (n.right != null) {
                    newLevel.add(n.right);
                }
            }
            res.add(vals);
            level = newLevel;
            left2Right = !left2Right;
        }

        return res;
    }
}
