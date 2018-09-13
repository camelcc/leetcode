public class S0211AddSearchWord {
    class WordDictionary {
        private class Node {
            char c;
            boolean word = false;
            Node[] children = new Node[26];

            public Node(char v, boolean w) {
                c = v;
                word = w;
            }
        }

        private Node root;

        public WordDictionary() {
            root = new Node('\0', false);
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node node = root;

            for (int i = 0; i < word.length(); i++) {
                boolean isLast = (i == word.length() - 1);

                char c = word.charAt(i);
                Node next = node.children[c - 'a'];
                if (next == null) {
                    next = new Node(c, isLast);
                    node.children[c-'a'] = next;
                } else {
                    if (isLast) {
                        next.word = true;
                    }
                }
                node = next;
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(root, word);
        }

        private boolean search(Node root, String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                boolean isLast = (i == word.length() - 1);
                char c = word.charAt(i);
                if (c == '.') {
                    if (isLast) {
                        for (Node child : node.children) {
                            if (child != null && child.word) {
                                return true;
                            }
                        }
                        return false;
                    } else {
                        for (Node child: node.children) {
                            if (child != null) {
                                if (search(child, word.substring(i+1))) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }

                Node next = node.children[c-'a'];
                if (next == null) {
                    return false;
                }

                if (isLast) {
                    return next.word;
                }

                node = next;
            }
            return false;
        }
    }
}
