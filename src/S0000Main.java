import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0857MinimumCostHireKWorkers workers = new S0857MinimumCostHireKWorkers();
        StdOut.println(workers.mincostToHireWorkers(new int[]{10,20,5}, new int[]{70,50,30}, 2));
    }
}
