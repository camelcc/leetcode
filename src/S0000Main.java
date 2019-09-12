import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1187MakeArrayStrictlyIncreasing s = new S1187MakeArrayStrictlyIncreasing();
        StdOut.println(s.makeArrayIncreasing(new int[]{1,5,3,6,7}, new int[]{1,3,2,4}));
        StdOut.println(s.makeArrayIncreasing(new int[]{1,5,3,6,7}, new int[]{4,3,1}));
        StdOut.println(s.makeArrayIncreasing(new int[]{1,5,3,6,7}, new int[]{1,6,3,3}));
    }
}
