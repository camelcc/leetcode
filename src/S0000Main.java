import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0385MiniParser parser = new S0385MiniParser();
        S0385MiniParser.NestedInteger res = parser.deserialize("[]");
        StdOut.println(res);
    }
}
