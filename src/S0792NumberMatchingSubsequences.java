import java.util.*;

public class S0792NumberMatchingSubsequences {
    private class Node {
        int count = 0;
        Node[] child;

        public Node(char c) {
            child = new Node[26];
        }
    }

    public int numMatchingSubseq(String S, String[] words) {
        // build tree
        Node root = new Node('\0');
        for (String word: words) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.child[c-'a'] == null) {
                    node.child[c-'a'] = new Node(c);
                }
                node = node.child[c-'a'];
                if (i == word.length()-1) {
                    node.count++;
                }
            }
        }

        int res = 0;
        List<Node>[] candidates = new List[26];
        for (int i = 0; i < 26; i++) {
            candidates[i] = new ArrayList<>();
            if (root.child[i] != null) {
                candidates[i].add(root.child[i]);
            }
        }

        for (char c : S.toCharArray()) {
            if (candidates[c-'a'].isEmpty()) {
                continue;
            }
            List<Node> t = candidates[c-'a'];
            candidates[c-'a'] = new ArrayList<>();
            for (Node n : t) {
                res += n.count;
                for (int i = 0; i < 26; i++) {
                    if (n.child[i] != null) {
                        candidates[i].add(n.child[i]);
                    }
                }
            }
        }
        return res;
    }
}
