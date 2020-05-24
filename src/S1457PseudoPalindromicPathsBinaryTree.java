import util.TreeNode;

import java.util.HashSet;

public class S1457PseudoPalindromicPathsBinaryTree {
    public int pseudoPalindromicPaths (TreeNode root) {
        return validPath(root, new HashSet<>());
    }

    private int validPath(TreeNode node, HashSet<Integer> prev) {
        assert node != null;
        HashSet<Integer> next = new HashSet<>(prev);
        if (next.contains(node.val)) {
            next.remove(node.val);
        } else {
            next.add(node.val);
        }

        if (node.left == null && node.right == null) { // leaf
            if (next.isEmpty() || next.size() == 1) {
                return 1;
            } else {
                return 0;
            }
        }
        int res = 0;
        if (node.left != null) {
            res += validPath(node.left, next);
        }
        if (node.right != null) {
            res += validPath(node.right, next);
        }
        return res;
    }
}
