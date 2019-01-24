import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0673NumberLongestIncreasingSubsequence sub = new S0673NumberLongestIncreasingSubsequence();
        StdOut.println(sub.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }
}
