import util.TreeNode;

public class S0106BTInorderPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        if (postorder.length == 1) {
            return root;
        }

        int count = 0;
        while (inorder[count] != root.val) {
            count++;
        }
        int[] leftIn = new int[count];
        int[] leftPost = new int[count];
        for (int i = 0; i < count; i++) {
            leftIn[i] = inorder[i];
            leftPost[i] = postorder[i];
        }
        root.left = buildTree(leftIn, leftPost);

        int rightCount = inorder.length-count-1;
        int[] rightIn = new int[rightCount];
        int[] rightPost = new int[rightCount];
        for (int i = 0; i < rightCount; i++) {
            rightIn[i] = inorder[i+count+1];
            rightPost[i] = postorder[count+i];
        }
        root.right = buildTree(rightIn, rightPost);
        return root;
    }
}
