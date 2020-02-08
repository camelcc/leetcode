import util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S1110DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }
        HashSet<Integer> del = new HashSet<>();
        for (int d : to_delete) {
            del.add(d);
        }
        return delete(root, del);
    }

    private List<TreeNode> delete(TreeNode root, HashSet<Integer> del) {
        List<TreeNode> res = new ArrayList<>();
        if (del.contains(root.val)) {
            if (root.left != null) {
                res.addAll(delete(root.left, del));
            }
            if (root.right != null) {
                res.addAll(delete(root.right, del));
            }
            return res;
        }

        res.add(root);
        if (root.left != null) {
            if (del.contains(root.left.val)) {
                if (root.left.left != null) {
                    res.addAll(delete(root.left.left, del));
                }
                if (root.left.right != null) {
                    res.addAll(delete(root.left.right, del));
                }
                root.left = null;
            } else {
                for (TreeNode n : delete(root.left, del)) {
                    if (n != root.left) {
                        res.add(n);
                    }
                }
            }
        }
        if (root.right != null) {
            if (del.contains(root.right.val)) {
                if (root.right.left != null) {
                    res.addAll(delete(root.right.left, del));
                }
                if (root.right.right != null) {
                    res.addAll(delete(root.right.right, del));
                }
                root.right = null;
            } else {
                for (TreeNode n : delete(root.right, del)) {
                    if (n != root.right) {
                        res.add(n);
                    }
                }
            }
        }
        return res;
    }
}
