import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        String[] strings = new String[] {"flower","flow","flight"};
        S0014LongestCommonPrefix s = new S0014LongestCommonPrefix();
        StdOut.print(s.longestCommonPrefix(strings));
    }
}
