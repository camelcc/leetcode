import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0004MedianTwoSortedArrays median = new S0004MedianTwoSortedArrays();
        StdOut.println(median.findMedianSortedArrays(new int[]{3},
                new int[]{-2,-1}));
    }
}
