import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0519RandomFlipMatrix.Solution solution = new S0519RandomFlipMatrix.Solution(2, 2);
        int[] p;
        p = solution.flip();
        p = solution.flip();
        p = solution.flip();
        p = solution.flip();
        StdOut.println(p);
    }
}
