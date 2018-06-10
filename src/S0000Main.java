import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0437PathSumIII pathSumIII = new S0437PathSumIII();
        S0437PathSumIII.TreeNode root = new S0437PathSumIII.TreeNode(10);
        root.left = new S0437PathSumIII.TreeNode(5);
        root.right = new S0437PathSumIII.TreeNode(-3);
        root.left.left = new S0437PathSumIII.TreeNode(3);
        root.left.right = new S0437PathSumIII.TreeNode(2);
        root.right.right = new S0437PathSumIII.TreeNode(11);
        root.left.left.left = new S0437PathSumIII.TreeNode(3);
        root.left.left.right = new S0437PathSumIII.TreeNode(-2);
        root.left.right.right = new S0437PathSumIII.TreeNode(1);
        StdOut.println(pathSumIII.pathSum(root, 8));
    }
}
