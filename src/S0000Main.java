import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1031MaximumSumTwoNonOverlappingSubarrays sub = new S1031MaximumSumTwoNonOverlappingSubarrays();
        StdOut.println(sub.maxSumTwoNoOverlap(new int[]{0,6,5,2,2,5,1,9,4}, 1, 2));
//        StdOut.println(sub.maxSumTwoNoOverlap(new int[]{2,1,5,6,0,9,5,0,3,8}, 4, 3));
    }
}
