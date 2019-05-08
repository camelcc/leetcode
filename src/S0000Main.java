import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0329LongestIncreasingPathMatrix matrix = new S0329LongestIncreasingPathMatrix();
        StdOut.println(matrix.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
    }
}
