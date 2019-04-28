import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0097InterleavingString string = new S0097InterleavingString();
        StdOut.println(string.isInterleave("aabc", "abad", "aabcabad"));
    }
}
