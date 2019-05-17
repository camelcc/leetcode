import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0587ErectFence fence = new S0587ErectFence();
        StdOut.println(fence.outerTrees(new int[][]{{5,5},{4,8},{1,3},{5,9},{3,0},{0,4},{3,2},{8,9},{9,3}}));
    }
}
