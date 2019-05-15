import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0480SlidingWindowMedian median = new S0480SlidingWindowMedian();
        StdOut.println(median.medianSlidingWindow(new int[]{1, 2}, 2));
    }
}
