import java.util.LinkedList;
import java.util.List;

public class S1032StreamCharacters {
    class StreamChecker {
        private class Trie {
            boolean word;
            Trie[] children;

            public Trie(boolean word) {
                this.word = word;
                children = new Trie[26];
            }
        }

        private Trie root;
        private List<Trie> match;

        public StreamChecker(String[] words) {
            root = new Trie(false);
            match = new LinkedList<>();
            for (String word : words) {
                Trie node = root;
                for (int i = 0; i < word.length(); i++) {
                    boolean last = i == word.length()-1;
                    char c = word.charAt(i);
                    if (node.children[c-'a'] == null) {
                        node.children[c-'a'] = new Trie(last);
                    }
                    node = node.children[c-'a'];
                    if (last) {
                        node.word = true;
                    }
                }
            }
        }

        public boolean query(char letter) {
            match.add(root);
            List<Trie> next = new LinkedList<>();
            boolean exist = false;
            for (Trie node : match) {
                if (node.children[letter-'a'] == null) {
                    continue;
                }
                if (node.children[letter-'a'].word) {
                    exist = true;
                }
                next.add(node.children[letter-'a']);
            }
            match = next;
            return exist;
        }
    }
}
