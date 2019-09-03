import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1177CanMakePalindromeSubstring s = new S1177CanMakePalindromeSubstring();
//        S1178 s = new S1178();
//        StdOut.println(s.numPrimeArrangements(5));
        StdOut.println(s.canMakePaliQueries("hunu", new int[][]{{1,1,1},{2,3,0},{3,3,1},{0,3,2},{1,3,3},{2,3,1},{3,3,1},{0,3,0},{1,1,1},{2,3,0},{3,3,1},{0,3,1},{1,1,1}}));
        StdOut.println(s.canMakePaliQueries("abcda", new int[][]{{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}}));
    }
}
