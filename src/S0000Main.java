import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1123LowestCommonAncestorDeepestLeaves.TreeNode root = new S1123LowestCommonAncestorDeepestLeaves.TreeNode(1);
        root.left = new S1123LowestCommonAncestorDeepestLeaves.TreeNode(2);
        root.right = new S1123LowestCommonAncestorDeepestLeaves.TreeNode(3);
        root.left.left = new S1123LowestCommonAncestorDeepestLeaves.TreeNode(4);
        S1123LowestCommonAncestorDeepestLeaves leaves = new S1123LowestCommonAncestorDeepestLeaves();
        StdOut.println(leaves.lcaDeepestLeaves(root));
    }
}
