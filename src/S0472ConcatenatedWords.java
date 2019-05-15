import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class S0472ConcatenatedWords {
    private static class Node {
        boolean word;
        Node[] children;

        public Node(boolean word) {
            this.word = word;
            children = new Node[26];
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Node root = new Node(false);
        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (concat(root, word)) {
                res.add(word);
            }
            add(root, word);
        }
        return res;
    }

    private boolean concat(Node root, String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c-'a'] == null) {
                return false;
            }
            node = node.children[c-'a'];
            if (node.word) {
                if (i == word.length()-1) {
                    return true;
                }

                if (concat(root, word.substring(i+1))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void add(Node root, String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new Node(i == word.length()-1);
            }
            node = node.children[c-'a'];
        }
    }
}
