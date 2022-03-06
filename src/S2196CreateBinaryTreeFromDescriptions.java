import java.util.HashMap;
import java.util.HashSet;

import util.TreeNode;

public class S2196CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> tree = new HashMap<>();
        HashSet<Integer> notRoot = new HashSet<>();
        for (int[] des : descriptions) {
            int p = des[0], c = des[1];
            boolean isLeft = des[2] == 1;
            notRoot.add(c);

            tree.putIfAbsent(p, new TreeNode(p));
            TreeNode parent = tree.get(p);
            tree.putIfAbsent(c, new TreeNode(c));
            TreeNode child = tree.get(c);
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        for (int p : tree.keySet()) {
            if (!notRoot.contains(p)) {
                return tree.get(p);
            }
        }
        return null;
    }
}
