import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1157OnlineMajorityElementInSubarray.MajorityChecker subarray = new S1157OnlineMajorityElementInSubarray.MajorityChecker(new int[]{2,1,1,1,2,1,2,1,2,2,1,1,2});
//        StdOut.println(subarray.query(0,5,4));
//        StdOut.println(subarray.query(0,3,3));
//        StdOut.println(subarray.query(2,3,2));
        StdOut.println(subarray.query(9, 11, 2));

    }
}
