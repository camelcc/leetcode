import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1224MaximumEqualFrequency s = new S1224MaximumEqualFrequency();
        StdOut.println(s.maxEqualFreq(new int[]{2,2,1,1,5,3,3,5}));
        StdOut.println(s.maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5}));
        StdOut.println(s.maxEqualFreq(new int[]{1,1,1,2,2,2}));
        StdOut.println(s.maxEqualFreq(new int[]{10,2,8,9,3,8,1,5,2,3,7,6}));
    }
}
