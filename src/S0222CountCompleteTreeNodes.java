public class S0222CountCompleteTreeNodes {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1;
        }

        int size = 1;
        int h = 1;
        TreeNode l = root;
        while (l.left != null) {
            size += 0x1 << h;
            h++;
            l = l.left;
        }
        if (hasRight(root, h)) {
            return size;
        }

        // not a perfect tree
        int lastLevelSize = 0x1 << (h-1);
        size -= lastLevelSize;

        // count last level
        int empty = 0;
        int lastLevel = findFirstEmptyNode(root, h, empty);
        return size + lastLevel;
    }

    private int findFirstEmptyNode(TreeNode node, int height, int empty) {
        if (node.left == null) {
            return empty * 2;
        }
        if (node.right == null) {
            return empty * 2 + 1;
        }

        if (hasRight(node.left, height-1)) {
            return findFirstEmptyNode(node.right, height-1, empty * 2 + 1);
        } else {
            return findFirstEmptyNode(node.left, height-1, empty * 2);
        }
    }

    private boolean hasRight(TreeNode node, int height) {
        assert node != null;
        assert height > 0;

        if (height == 1) {
            return true;
        }
        if (node.right == null) {
            return false;
        }

        return hasRight(node.right, height-1);
    }
}
