import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S1004MaxConsecutiveOnesIII ones = new S1004MaxConsecutiveOnesIII();
        StdOut.println(ones.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
