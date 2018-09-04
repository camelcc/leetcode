import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0508MostFrequentSubtreeSum sum = new S0508MostFrequentSubtreeSum();
        S0508MostFrequentSubtreeSum.TreeNode root = new S0508MostFrequentSubtreeSum.TreeNode(5);
        root.left = new S0508MostFrequentSubtreeSum.TreeNode(2);
        root.right = new S0508MostFrequentSubtreeSum.TreeNode(-3);
        StdOut.println(sum.findFrequentTreeSum(root));
    }
}
