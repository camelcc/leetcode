import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class S0000Main {
    public static void main(String[] args) {
        S0127WordLadder ladder = new S0127WordLadder();
        StdOut.println(ladder.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log", "cog")));
    }
}
