import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0919CompleteBinaryTreeInserter.TreeNode root = new S0919CompleteBinaryTreeInserter.TreeNode(1);
        root.left = new S0919CompleteBinaryTreeInserter.TreeNode(2);
        S0919CompleteBinaryTreeInserter.CBTInserter t = new S0919CompleteBinaryTreeInserter.CBTInserter(root);
        StdOut.println(t.insert(3));
        StdOut.println(t.insert(4));
    }
}
