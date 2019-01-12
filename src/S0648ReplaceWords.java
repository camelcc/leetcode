import java.util.List;

public class S0648ReplaceWords {
    private class Node {
        char c;
        boolean word;
        Node[] child;

        public Node(char c) {
            this.c = c;
            child = new Node[26];
        }
    }
    private Node root = null;

    private void add(String word) {
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            boolean end = (i == word.length()-1);
            char c = word.charAt(i);
            if (n.child[c-'a'] == null) {
                n.child[c-'a'] = new Node(c);
            }
            n = n.child[c-'a'];
            if (end) {
                n.word = true;
            }
        }
    }

    private String find(String word) {
        StringBuilder sb = new StringBuilder();
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.child[c-'a'] == null) {
                return word;
            }
            sb.append(c);
            if (node.child[c-'a'].word) {
                return sb.toString();
            }

            node = node.child[c-'a'];
        }
        return word;
    }

    public String replaceWords(List<String> dict, String sentence) {
        root = new Node('\0');
        for (String word : dict) {
            add(word);
        }

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = find(words[i]);
        }
        return String.join(" ", words);
    }
}
