import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0581ShortestUnsortedContinuousSubarray subarray = new S0581ShortestUnsortedContinuousSubarray();
        StdOut.println(subarray.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }
}
