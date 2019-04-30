import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0145BinaryTreePostorderTraversal traversal = new S0145BinaryTreePostorderTraversal();
        S0145BinaryTreePostorderTraversal.TreeNode root = new S0145BinaryTreePostorderTraversal.TreeNode(1);
        root.right = new S0145BinaryTreePostorderTraversal.TreeNode(2);
        root.right.left = new S0145BinaryTreePostorderTraversal.TreeNode(3);
        traversal.postorderTraversal(root);
    }
}
