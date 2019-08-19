import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S5069LastSubstringLexicographicalOrder order = new S5069LastSubstringLexicographicalOrder();
        StdOut.println(order.lastSubstring("abab"));
        StdOut.println(order.lastSubstring("leetcode"));
        StdOut.println(order.lastSubstring("zrziy"));
        StdOut.println(order.lastSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        StdOut.println(order.lastSubstring("xbylisvborylklftlkcioajuxwdhahdgezvyjbgaznzayfwsaumeccpfwamfzmkinezzwobllyxktqeibfoupcpptncggrdqbkji"));
    }
}
