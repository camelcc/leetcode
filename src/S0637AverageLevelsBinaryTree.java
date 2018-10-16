import java.util.ArrayList;
import java.util.List;

public class S0637AverageLevelsBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();

            double sum = 0;
            for (TreeNode node : level) {
                sum += node.val;
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            res.add(sum/level.size());
            level = nextLevel;
        }
        return res;
    }
}
