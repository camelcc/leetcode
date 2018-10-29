import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0064MinimumPathSum sum = new S0064MinimumPathSum();
        StdOut.println(sum.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
