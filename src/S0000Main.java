import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0871MinimumNumberRefuelingStops stops = new S0871MinimumNumberRefuelingStops();
        StdOut.println(stops.minRefuelStops(1000000, 70768, new int[][]{{12575,171159},{81909,101253},{163732,164401},{190025,65493},{442889,31147},{481202,166081},{586028,206379},{591952,52748},{595013,9163},{611883,217156}}));
    }
}
