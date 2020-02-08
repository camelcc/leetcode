import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S0257BTPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        if (root.left != null) {
            res.addAll(paths(String.valueOf(root.val), root.left));
        }

        if (root.right != null) {
            res.addAll(paths(String.valueOf(root.val), root.right));
        }
        return res;
    }

    public List<String> paths(String pre, TreeNode node) {
        List<String> strings = new ArrayList<>();
        if (node.left == null && node.right == null) {
            strings.add(pre+"->"+node.val);
            return strings;
        }

        if (node.left != null) {
            strings.addAll(paths(pre + "->" + node.val, node.left));
        }
        if (node.right != null) {
            strings.addAll(paths(pre + "->" + node.val, node.right));
        }
        return strings;
    }
}
