import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0980UniquePathsIII pathsIII = new S0980UniquePathsIII();
        StdOut.println(pathsIII.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }
}
