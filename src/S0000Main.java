import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1210MinimumMovesReachTargetRotations s = new S1210MinimumMovesReachTargetRotations();
        StdOut.println(s.minimumMoves(new int[][]{{0,0,0,0,0,1},
                {1,1,0,0,1,0},
                {0,0,0,0,1,1},
                {0,0,1,0,1,0},
                {0,1,1,0,0,0},
                {0,1,1,0,0,0}}));
        StdOut.println(s.minimumMoves(new int[][]{{0,0,1,1,1,1},
                {0,0,0,0,1,1},
                {1,1,0,0,0,1},
                {1,1,1,0,0,1},
                {1,1,1,0,0,1},
                {1,1,1,0,0,0}}));
        StdOut.println(s.minimumMoves(new int[][]{{0,0,0,0,0,0,0,0,0,1},{0,1,0,0,0,0,0,1,0,1},{1,0,0,1,0,0,1,0,1,0},{0,0,0,1,0,1,0,1,0,0},{0,0,0,0,1,0,0,0,0,1},{0,0,1,0,0,0,0,0,0,0},{1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0,0}}
        ));
    }
}
