import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1509MinimumDifferenceBetweenLargestSmallestValueThreeMoves s = new S1509MinimumDifferenceBetweenLargestSmallestValueThreeMoves();
        StdOut.println(s.minDifference(new int[]{5,3,2,4}));
        StdOut.println(s.minDifference(new int[]{1,5,0,10,14}));
        StdOut.println(s.minDifference(new int[]{6,6,0,1,1,4,6}));
        StdOut.println(s.minDifference(new int[]{1,5,6,14,15}));
    }
}
