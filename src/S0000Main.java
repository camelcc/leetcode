import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1218LongestArithmeticSubsequenceGivenDifference s = new S1218LongestArithmeticSubsequenceGivenDifference();
        StdOut.println(s.longestSubsequence(new int[]{1,2,3,4}, 1));
        StdOut.println(s.longestSubsequence(new int[]{1,3,5,7}, 1));
        StdOut.println(s.longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));
        StdOut.println(s.longestSubsequence(new int[]{-12,-12,-10,-3,-8,-11,-7,3,12,3,7,4}, -11));
    }
}
