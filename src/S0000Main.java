import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0835ImageOverlap overlap = new S0835ImageOverlap();
        StdOut.println(overlap.largestOverlap(new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 0}}, new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 0, 1}}));
    }
}
