import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S0872LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        travel(root1, leaf1);
        List<Integer> leaf2 = new ArrayList<>();
        travel(root2, leaf2);
        return leaf1.equals(leaf2);
    }

    private void travel(TreeNode root, List<Integer> data) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            data.add(root.val);
            return;
        }

        travel(root.left, data);
        travel(root.right, data);
    }
}
