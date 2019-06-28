import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0930BinarySubarraysWithSum sum = new S0930BinarySubarraysWithSum();
        StdOut.println(sum.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }
}
