import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0792NumberMatchingSubsequences seq = new S0792NumberMatchingSubsequences();
        StdOut.println(seq.numMatchingSubseq("abcde", new String[] {"a","bb","acd","ace"}));
    }
}
