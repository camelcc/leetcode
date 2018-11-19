import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0307RangeSumQueryMutable.NumArray array = new S0307RangeSumQueryMutable.NumArray(new int[]{7, 2, 7, 2, 0});
        array.update(4, 6);
        array.update(0, 2);
        array.update(0, 9);
        StdOut.println(array.sumRange(4, 4));
        array.update(3, 8);
        StdOut.println(array.sumRange(0, 4));
    }
}
