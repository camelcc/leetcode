import java.util.ArrayList;
import java.util.List;

public class S0107BinaryTreeOrderTraversalII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> rootLevel = new ArrayList<>();
        rootLevel.add(root.val);
        res.add(rootLevel);

        List<TreeNode> uplevel = new ArrayList<>();
        uplevel.add(root);
        while (uplevel.size() > 0) {
            List<TreeNode> levelNodes = new ArrayList<>();
            List<Integer> nodes = new ArrayList<>();
            for (TreeNode node : uplevel) {
                if (node.left != null) {
                    levelNodes.add(node.left);
                    nodes.add(node.left.val);
                }
                if (node.right != null) {
                    levelNodes.add(node.right);
                    nodes.add(node.right.val);
                }
            }
            uplevel = levelNodes;
            if (nodes.size() > 0) {
                res.add(0, nodes);
            }
        }
        return res;
    }
}
