package util;

import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode fromArray(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        LinkedList<TreeNode> level = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        level.offer(root);
        int p = 1;
        while (p < array.length) {
            LinkedList<TreeNode> next = new LinkedList<>();
            for (TreeNode n : level) {
                n.left = array[p] == null ? null : new TreeNode(array[p]);
                p++;
                if (p >= array.length) {
                    break;
                }
                if (n.left != null) {
                    next.offer(n.left);
                }
                n.right = array[p] == null ? null : new TreeNode(array[p]);
                p++;
                if (p >= array.length) {
                    break;
                }
                if (n.right != null) {
                    next.offer(n.right);
                }
                level = next;
            }
        }
        return root;
    }
}
