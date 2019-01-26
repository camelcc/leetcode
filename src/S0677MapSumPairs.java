import java.util.ArrayList;
import java.util.List;

public class S0677MapSumPairs {
    class MapSum {
        private class Node {
            Node[] child;
            int v;

            public Node(int v) {
                this.v = v;
                child = new Node[26];
            }
        }
        private Node root;

        public MapSum() {
            root = new Node(0);
        }

        public void insert(String key, int val) {
            Node n = root;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (n.child[c-'a'] == null) {
                    n.child[c-'a'] = new Node(0);
                }
                n = n.child[c-'a'];

                if (i == key.length()-1) {
                    n.v = val;
                }
            }
        }

        public int sum(String prefix) {
            Node n = root;
            for (char c : prefix.toCharArray()) {
                if (n.child[c-'a'] == null) {
                    return 0;
                }
                n = n.child[c-'a'];
            }
            List<Node> bfs = new ArrayList<>();
            bfs.add(n);

            int res = 0;
            while (!bfs.isEmpty()) {
                Node t = bfs.remove(0);
                res += t.v;
                for (int i = 0; i < 26; i++) {
                    if (t.child[i] != null) {
                        bfs.add(t.child[i]);
                    }
                }
            }
            return res;
        }
    }
}
