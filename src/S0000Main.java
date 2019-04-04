import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0861ScoreAfterFlippingMatrix matrix = new S0861ScoreAfterFlippingMatrix();
        StdOut.println(matrix.matrixScore(new int[][] {{0, 1}, {0, 1}, {0, 1}, {0, 0}}));
    }
}
