import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0010RegularExpressionMatching matching = new S0010RegularExpressionMatching();
        StdOut.println(matching.isMatch("", ".*"));
    }
}
