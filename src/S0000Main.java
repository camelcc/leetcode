import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class S0000Main {
    public static void main(String[] args) {
        S1192CriticalConnectionsNetwork network = new S1192CriticalConnectionsNetwork();
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> e1 = new ArrayList<>();
        e1.add(0);
        e1.add(1);
        graph.add(e1);
        List<Integer> e2 = new ArrayList<>();
        e2.add(1);
        e2.add(2);
        graph.add(e2);
        List<Integer> e3 = new ArrayList<>();
        e3.add(2);
        e3.add(0);
        graph.add(e3);
        List<Integer> e4 = new ArrayList<>();
        e4.add(1);
        e4.add(3);
        graph.add(e4);
        StdOut.println(network.criticalConnections(4, graph));
    }

}
