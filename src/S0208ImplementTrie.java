public class S0208ImplementTrie {
    class Trie {
        class Node {
            boolean valid;
            Node[] child;

            public Node(boolean valid) {
                this.valid = valid;
                this.child = new Node[26];
            }
        }

        private Node root;

        public Trie() {
            root = new Node(false);
        }

        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.child[c-'a'] == null) {
                    node.child[c-'a'] = new Node(i == (word.length()-1));
                }
                node = node.child[c-'a'];
            }
            node.valid = true;
        }

        public boolean search(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.child[c-'a'] == null) {
                    return false;
                }
                node = node.child[c-'a'];
            }
            return node.valid;
        }

        public boolean startsWith(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (node.child[c-'a'] == null) {
                    return false;
                }
                node = node.child[c-'a'];
            }
            return true;
        }
    }
}
