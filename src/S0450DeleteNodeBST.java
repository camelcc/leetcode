import util.TreeNode;

public class S0450DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            TreeNode m = getMax(root.left);
            root.val = m.val;
            root.left = deleteMax(root.left);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else { // root.val < key
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode getMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    private TreeNode deleteMax(TreeNode root) {
        if (root.right == null) {
            return root.left;
        }

        TreeNode n = root;
        while (n.right.right != null) {
            n = n.right;
        }
        n.right = n.right.left;
        return root;
    }
}
