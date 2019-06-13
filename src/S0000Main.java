import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0307RangeSumQueryMutable.NumArray sum = new S0307RangeSumQueryMutable.NumArray(new int[]{9, -8});
        sum.update(0, 3);
        StdOut.println(sum.sumRange(1, 1));
        StdOut.println(sum.sumRange(0, 1));
        sum.update(1, -3);
        StdOut.println(sum.sumRange(0, 1));
    }
}
