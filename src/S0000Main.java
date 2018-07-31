import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0222CountCompleteTreeNodes nodes = new S0222CountCompleteTreeNodes();
        S0222CountCompleteTreeNodes.TreeNode root = new S0222CountCompleteTreeNodes.TreeNode(1);
        root.left = new S0222CountCompleteTreeNodes.TreeNode(2);
        root.left.left = new S0222CountCompleteTreeNodes.TreeNode(4);
        root.left.right = new S0222CountCompleteTreeNodes.TreeNode(5);
        root.right = new S0222CountCompleteTreeNodes.TreeNode(3);
        root.right.left = new S0222CountCompleteTreeNodes.TreeNode(6);
        StdOut.println(nodes.countNodes(root));
    }
}
