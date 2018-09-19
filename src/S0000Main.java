import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0332ReconstructItinerary itinerary = new S0332ReconstructItinerary();
        StdOut.println(itinerary.findItinerary(new String[][] {
                {"JFK","AAA"},
                {"AAA","JFK"},
                {"JFK","BBB"},
                {"JFK","CCC"},
                {"CCC","JFK"}}));
    }
}
