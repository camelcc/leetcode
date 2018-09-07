import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0540SingleElementSortedArray array = new S0540SingleElementSortedArray();
        StdOut.println(array.singleNonDuplicate(new int[] {1, 1,
                2,
                2,
                4,
                4,
                5,
                5,9}));
    }
}
