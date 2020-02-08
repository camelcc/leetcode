import util.TreeNode;

import java.util.*;

public class S0652FindDuplicateSubtrees {
    private HashMap<String, TreeNode> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashSet<TreeNode> res = new HashSet<>();
        presentTree(root, res);
        return new ArrayList<>(res);
    }

    private String presentTree(TreeNode root, HashSet<TreeNode> dup) {
        if (root == null) {
            return "";
        }
        String res = presentTree(root.left, dup) + "L" + presentTree(root.right, dup) + "R" + root.val;
        if (!map.containsKey(res)) {
            map.put(res, root);
        } else {
            dup.add(map.get(res));
        }
        return res;
    }
}
