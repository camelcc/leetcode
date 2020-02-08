import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S0513FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> upLevel = new ArrayList<>();

        List<TreeNode> level = new ArrayList<>();
        level.add(root);

        while (!level.isEmpty()) {
            upLevel.clear();
            upLevel.addAll(level);

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

        return upLevel.get(0).val;
    }
}
