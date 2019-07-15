public class S1008ConstructBinarySearchTreePreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, 0, preorder.length-1);
    }

    private TreeNode bst(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(preorder[start]);
        }
        TreeNode root = new TreeNode(preorder[start]);
        int v = root.val;
        int right = start+1;
        while (right <= end && preorder[right] < v) {
            right++;
        }
        root.left = bst(preorder, start+1, right-1);
        root.right = bst(preorder, right, end);
        return root;
    }
}
