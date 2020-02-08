import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S0655PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        int[] mn = traverse(root);
        return print(root, mn[0], mn[1]);
    }

    private List<List<String>> print(TreeNode root, int height, int width) {
        List<String> top = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            top.add("");
        }
        top.set(width/2, String.valueOf(root.val));

        List<List<String>> res = new ArrayList<>();
        res.add(top);
        if (height == 1) {
            return res;
        }
        List<String> t = new ArrayList<>();
        for (int i = 0; i < width/2; i++) {
            t.add("");
        }

        List<List<String>> left = new ArrayList<>();
        if (root.left != null) {
            left = print(root.left, height-1, width/2);
        } else {
            for (int i = 0; i < height-1; i++) {
                left.add(new ArrayList<>(t));
            }
        }

        List<List<String>> right = new ArrayList<>();
        if (root.right != null) {
            right = print(root.right, height-1, width/2);
        } else {
            for (int i = 0; i < height - 1; i++) {
                right.add(new ArrayList<>(t));
            }
        }

        for (int i = 0; i < height-1; i++) {
            List<String> level = new ArrayList<>();
            level.addAll(left.get(i));
            level.add("");
            level.addAll(right.get(i));
            res.add(level);
        }

        return res;
    }

    private int[] traverse(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }

        int[] left = new int[2];
        int[] right = new int[2];
        if (root.left != null) {
            left = traverse(root.left);
        }
        if (root.right != null) {
            right = traverse(root.right);
        }
        res[0] = Math.max(left[0], right[0]) + 1;
        res[1] = 2 * Math.max(left[1], right[1]) + 1;
        return res;
    }
}
