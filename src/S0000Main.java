import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0719FindKthSmallestPairDistance distance = new S0719FindKthSmallestPairDistance();
        StdOut.println(distance.smallestDistancePair(new int[]{9,10,7,10,6,1,5,4,9,8}, 18));
    }
}
