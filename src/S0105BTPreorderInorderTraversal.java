public class S0105BTPreorderInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }

        int count = 0;
        while (inorder[count] != root.val) {
            count++;
        }
        int[] leftIn = new int[count];
        int[] leftPre = new int[count];
        for (int i = 0; i < count; i++) {
            leftIn[i] = inorder[i];
            leftPre[i] = preorder[i+1];
        }
        root.left = buildTree(leftPre, leftIn);

        int rightCount = inorder.length-count-1;
        int[] rightIn = new int[rightCount];
        int[] rightPre = new int[rightCount];
        for (int i = 0; i < rightCount; i++) {
            rightIn[i] = inorder[i+count+1];
            rightPre[i] = preorder[i+count+1];
        }
        root.right = buildTree(rightPre, rightIn);
        return root;
    }
}
