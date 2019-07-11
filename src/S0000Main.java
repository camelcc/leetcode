import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0986IntervalListIntersections intervalListIntersections = new S0986IntervalListIntersections();
        StdOut.println(intervalListIntersections.intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}}, new int[][]{{1,5},{8,12},{15,24},{25,26}}));
    }
}
