import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0310MinimumHeightTrees tree = new S0310MinimumHeightTrees();
        StdOut.println(tree.findMinHeightTrees(6, new int[][] {{3,0}, {3,1}, {3,2}, {3,4}, {5,4}}));
    }
}
