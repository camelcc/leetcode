import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S1382BalanceBinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> data = new ArrayList<>();
        travel(root, data);
        int[] d = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            d[i] = data.get(i);
        }
        return generate(d, 0, d.length);
    }

    private void travel(TreeNode root, List<Integer> data) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            travel(root.left, data);
        }
        data.add(root.val);
        if (root.right != null) {
            travel(root.right, data);
        }
    }

    // [start, end)
    private TreeNode generate(int[] v, int start, int end) {
        int len = end-start;
        if (len == 0) {
            return null;
        } else if (len == 1) {
            return new TreeNode(v[start]);
        }
        int mid = start+len/2;
        TreeNode root = new TreeNode(v[mid]);
        root.left = generate(v, start, mid);
        root.right = generate(v, mid+1, end);
        return root;
    }
}
