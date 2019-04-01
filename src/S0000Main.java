import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0851LoudRich rich = new S0851LoudRich();
        StdOut.println(rich.loudAndRich(new int[][] {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}}, new int[]{3,2,5,4,6,1,7,0}));
    }
}
