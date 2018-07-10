import java.util.ArrayList;
import java.util.List;

public class S0127WordLadder {
    private static class Node {
        int steps;
        String word;
        List<Node> wordList;

        public Node(int steps, String word, List<Node> wordList) {
            this.steps = steps;
            this.word = word;
            this.wordList = wordList;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        List<String> l = new ArrayList<>(wordList);
        l.remove(beginWord);


        return 0;
    }

    private List<String> adj(String word, List<String> wordList) {
        List<String> res = new ArrayList<>();
        for (String w : wordList) {
            if (isAdj(word, w)) {
                res.add(w);
            }
        }
        return res;
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
