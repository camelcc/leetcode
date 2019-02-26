import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0787CheapestFlightsWithinKStops stops = new S0787CheapestFlightsWithinKStops();
        StdOut.println(stops.findCheapestPrice(5, new int[][] {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}}, 0, 2, 2));
    }
}
