public class S0676ImplementMagicDictionary {
    class MagicDictionary {
        private class Node {
            boolean word;
            char c;
            Node[] child;

            public Node(char c) {
                this.c = c;
                child = new Node[26];
                word = false;
            }
        }

        private Node root;

        public MagicDictionary() {
            root = new Node('\0');
        }

        public void buildDict(String[] dict) {
            for (String d : dict) {
                Node n = root;
                for (int i = 0; i < d.length(); i++) {
                    char c = d.charAt(i);
                    if (n.child[c-'a'] == null) {
                        n.child[c-'a'] = new Node(c);
                    }
                    n = n.child[c-'a'];
                    if (i == d.length()-1) {
                        n.word=true;
                    }
                }
            }
        }

        public boolean search(String word) {
            return search(root, word.toCharArray(), 0, true);
        }

        private boolean search(Node root, char[] word, int index, boolean modify) {
            if (root == null) {
                return false;
            }
            char c = word[index];
            Node n = root.child[c-'a'];

            if (!modify) {
                if (n == null) {
                    return false;
                }
                if (index == word.length-1) {
                    return n.word;
                }

                return search(n, word, index+1, false);
            } else {
                if (index == word.length-1) {
                    for (int i = 0; i < 26; i++) {
                        if (root.child[i] != null && root.child[i].word && root.child[i] != n) {
                            return true;
                        }
                    }
                } else {
                    for (int i = 0; i < 26; i++) {
                        if (root.child[i] != null) {
                            if (root.child[i] == n) {
                                if (search(n, word, index+1, true)) {
                                    return true;
                                }
                            } else {
                                if (search(root.child[i], word, index + 1, false)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }

            return false;
        }
    }
}
