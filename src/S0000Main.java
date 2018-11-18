import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0300LongestIncreasingSubsequence seq = new S0300LongestIncreasingSubsequence();
        StdOut.println(seq.lengthOfLIS(new int[]{-2, -1}));
    }
}
