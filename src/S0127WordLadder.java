import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class S0127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        List<String> visited = new ArrayList<>();
        visited.add(beginWord);

        List<Pair<Integer, String>> nodes = new ArrayList<>();
        nodes.add(new Pair<>(1, beginWord));
        while (!nodes.isEmpty()) {
            Pair<Integer, String> n = nodes.remove(0);
            List<String> adjcents = new ArrayList<>();
            for (String w : wordList) {
                if (isAdj(n.getValue(), w)) {
                    adjcents.add(w);
                }
            }

            for (String adj : adjcents) {
                if (visited.contains(adj)) {
                    continue;
                }
                if (adj.equals(endWord)) {
                    return n.getKey()+1;
                }

                nodes.add(new Pair<>(n.getKey()+1, adj));
                visited.add(adj);
            }
        }
        return 0;
    }

    private boolean isAdj(String a, String b) {
        assert !a.isEmpty();
        assert a.length() == b.length();
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;

                if (diff >= 2) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
