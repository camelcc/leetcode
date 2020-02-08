import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S00102BTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            List<TreeNode> newLevel = new ArrayList<>();
            for (TreeNode n : level) {
                vals.add(n.val);
                if (n.left != null) {
                    newLevel.add(n.left);
                }
                if (n.right != null) {
                    newLevel.add(n.right);
                }
            }
            res.add(vals);
            level = newLevel;
        }

        return res;
    }
}
