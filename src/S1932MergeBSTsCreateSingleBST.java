import util.TreeNode;

import java.util.*;

public class S1932MergeBSTsCreateSingleBST {
    public TreeNode canMerge(List<TreeNode> trees) {
        int[] cnt = new int[50001];
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (TreeNode tree: trees) {
            map.put(tree.val, tree);
            cnt[tree.val]++;
            if (tree.left != null) {
                cnt[tree.left.val] += 2;
            }
            if (tree.right != null) {
                cnt[tree.right.val] += 2;
            }
        }
        int root = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 1) {
                if (root != 0) {
                    return null;
                }
                root = i;
            }
        }
        TreeNode tree = build(map, map.remove(root));
        if (!map.isEmpty()) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        dfs(tree, res);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= res.get(i-1)) {
                return null;
            }
        }
        return tree;
    }

    private TreeNode build(HashMap<Integer, TreeNode> map, TreeNode root) {
        if (root == null || map.isEmpty()) {
            return root;
        }
        if (root.left != null && map.containsKey(root.left.val)) {
            root.left = build(map, map.remove(root.left.val));
        }
        if (root.right != null && map.containsKey(root.right.val)) {
            root.right = build(map, map.remove(root.right.val));
        }
        return root;
    }

    private void dfs(TreeNode root, List<Integer> data) {
        if (root == null) {
            return;
        }
        dfs(root.left, data);
        data.add(root.val);
        dfs(root.right, data);
    }
}
