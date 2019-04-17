import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0889ConstructBinaryTreePreorderPostorderTraversal traversal = new S0889ConstructBinaryTreePreorderPostorderTraversal();
        StdOut.println(traversal.constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1}));
    }
}
