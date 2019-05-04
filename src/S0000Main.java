import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0212WordSearchII search = new S0212WordSearchII();
        StdOut.println(search.findWords(new char[][]{
                {'b','a','a','b','a','b'},
                {'a','b','a','a','a','a'},
                {'a','b','a','a','a','b'},
                {'a','b','a','b','b','a'},
                {'a','a','b','b','a','b'},
                {'a','a','b','b','b','a'},
                {'a','a','b','a','a','b'}},
                new String[]{
                        "bbaabaabaaaaabaababaaaaababb",
                        "aabbaaabaaabaabaaaaaabbaaaba",
                        "babaababbbbbbbaabaababaabaaa",
                        "bbbaaabaabbaaababababbbbbaaa",
                        "babbabbbbaabbabaaaaaabbbaaab",
                        "bbbababbbbbbbababbabbbbbabaa",
                        "babababbababaabbbbabbbbabbba",
                        "abbbbbbaabaaabaaababaabbabba",
                        "aabaabababbbbbbababbbababbaa",
                        "aabbbbabbaababaaaabababbaaba",
                        "ababaababaaabbabbaabbaabbaba",
                        "abaabbbaaaaababbbaaaaabbbaab",
                        "aabbabaabaabbabababaaabbbaab",
                        "baaabaaaabbabaaabaabababaaaa",
                        "aaabbabaaaababbabbaabbaabbaa",
                        "aaabaaaaabaabbabaabbbbaabaaa",
                        "abbaabbaaaabbaababababbaabbb",
                        "baabaababbbbaaaabaaabbababbb",
                        "aabaababbaababbaaabaabababab",
                        "abbaaabbaabaabaabbbbaabbbbbb",
                        "aaababaabbaaabbbaaabbabbabab",
                        "bbababbbabbbbabbbbabbbbbabaa",
                        "abbbaabbbaaababbbababbababba",
                        "bbbbbbbabbbababbabaabababaab",
                        "aaaababaabbbbabaaaaabaaaaabb",
                        "bbaaabbbbabbaaabbaabbabbaaba",
                        "aabaabbbbaabaabbabaabababaaa",
                        "abbababbbaababaabbababababbb",
                        "aabbbabbaaaababbbbabbababbbb",
                        "babbbaabababbbbbbbbbaabbabaa"}));
    }
}
