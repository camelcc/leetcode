import java.util.HashSet;
import java.util.LinkedList;

public class S1993OperationsTree {
    public static class LockingTree {
        private static class Node {
            int pos;
            int locked;
            HashSet<Node> child;

            public Node(int p) {
                pos = p;
                child = new HashSet<>();
            }
        }

        private Node[] tree;
        private int[] parent;

        public LockingTree(int[] parent) {
            this.parent = parent;
            tree = new Node[parent.length];
            for (int i = 0; i < parent.length; i++) {
                tree[i] = new Node(i);
            }
            for (int i = 1; i < parent.length; i++) {
                tree[parent[i]].child.add(tree[i]);
            }
        }

        public boolean lock(int num, int user) {
            if (tree[num].locked != 0) {
                return false;
            }
            tree[num].locked = user;
            return true;
        }

        public boolean unlock(int num, int user) {
            if (tree[num].locked != user) {
                return false;
            }
            tree[num].locked = 0;
            return true;
        }

        public boolean upgrade(int num, int user) {
            if (tree[num].locked != 0) {
                return false;
            }

            int n = parent[num];
            while (n != -1) {
                if (tree[n].locked != 0) {
                    return false;
                }
                n = parent[n];
            }

            boolean good = false;
            LinkedList<Node> bfs = new LinkedList<>();
            bfs.offer(tree[num]);
            while (!bfs.isEmpty()) {
                Node node = bfs.poll();
                if (node.locked != 0) {
                    good = true;
                    node.locked = 0;
                }
                for (Node c : node.child) {
                    bfs.offer(c);
                }
            }
            if (!good) {
                return false;
            }

            tree[num].locked = user;
            return true;
        }
    }
}
