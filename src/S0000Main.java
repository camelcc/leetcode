import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0054SpiralMatrix matrix = new S0054SpiralMatrix();
        StdOut.println(matrix.spiralOrder(new int[][]{{2,5},{8,4},{0, -1}}));
    }
}
