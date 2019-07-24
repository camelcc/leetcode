import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S1123LowestCommonAncestorDeepestLeaves {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        HashMap<Integer, TreeNode> map = new HashMap<>();
        List<TreeNode> leaf = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        leaf.add(root);
        index.add(1);
        map.put(1, root);
        boolean hasChild = true;
        while (hasChild) {
            hasChild = false;
            List<TreeNode> next = new ArrayList<>();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < leaf.size(); i++) {
                TreeNode n = leaf.get(i);
                int pos = index.get(i);
                if (n.left != null) {
                    hasChild = true;
                    next.add(n.left);
                    level.add(pos*2);
                    map.put(pos*2, n.left);
                }
                if (n.right != null) {
                    hasChild = true;
                    next.add(n.right);
                    level.add(pos*2+1);
                    map.put(pos*2+1, n.right);
                }
            }
            if (hasChild) {
                leaf = next;
                index = level;
            }
        }
        assert index.size() > 0;
        while (index.size() != 1) {
            List<Integer> parent = new ArrayList<>();
            for (int n : index) {
                if (!parent.contains(n/2)) {
                    parent.add(n/2);
                }
            }
            index = parent;
        }
        return map.get(index.get(0));
    }
}
