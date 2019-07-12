import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0993CousinsBinaryTree bt = new S0993CousinsBinaryTree();
        S0993CousinsBinaryTree.TreeNode root = new S0993CousinsBinaryTree.TreeNode(1);
        root.left = new S0993CousinsBinaryTree.TreeNode(2);
        root.right = new S0993CousinsBinaryTree.TreeNode(3);
        root.right.left = new S0993CousinsBinaryTree.TreeNode(4);
        root.right.right = new S0993CousinsBinaryTree.TreeNode(5);
        StdOut.println(bt.isCousins(root, 4, 5));
    }
}
