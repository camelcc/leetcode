import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1406StoneGameIII s = new S1406StoneGameIII();
        StdOut.println(s.stoneGameIII(new int[]{1,2,3,7}));
        StdOut.println(s.stoneGameIII(new int[]{1,2,3,-9}));
        StdOut.println(s.stoneGameIII(new int[]{1,2,3,6}));
        StdOut.println(s.stoneGameIII(new int[]{1,2,3,-1,-2,-3,7}));
        StdOut.println(s.stoneGameIII(new int[]{-1,-2,-3}));
    }
}
