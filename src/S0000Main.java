import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0239SlidingWindowMaximum maximum = new S0239SlidingWindowMaximum();
        StdOut.println(maximum.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }
}
