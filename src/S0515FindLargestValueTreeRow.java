import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S0515FindLargestValueTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<TreeNode> level = new ArrayList<>();
        level.add(root);

        while (!level.isEmpty()) {
            int max = level.get(0).val;
            for (int i = 1; i < level.size(); i++) {
                if (level.get(i).val > max) {
                    max = level.get(i).val;
                }
            }
            res.add(max);

            List<TreeNode> newLevel = new ArrayList<>();
            for (TreeNode n : level) {
                if (n.left != null) {
                    newLevel.add(n.left);
                }
                if (n.right != null) {
                    newLevel.add(n.right);
                }
            }
            level = newLevel;
        }

        return res;
    }
}
