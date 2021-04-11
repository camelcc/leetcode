import java.util.*;

public class S1632RankTransformMatrix {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Node[][] nodes = new Node[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                nodes[i][j] = new Node(matrix[i][j]);
            }
        }
        // row dependency.
        for(int i = 0; i < m; ++i) {
            List<Node> row = new ArrayList<>();
            for(int j = 0; j < n; ++j) {
                row.add(nodes[i][j]);
            }
            Collections.sort(row, (a, b) -> Integer.compare(a.value, b.value));
            for(int j = 1; j < n; ++j) {
                Node previous = row.get(j-1);
                Node current = row.get(j);
                if (current.value > previous.value) { // previous is a dependency.
                    current.find().previouses.add(previous);
                } else { // previous is the same as current.
                    current.union(previous);
                }
            }
        }
        // col dependency.
        for(int j = 0; j < n; ++j) {
            List<Node> col = new ArrayList<>();
            for(int i = 0; i < m; ++i) {
                col.add(nodes[i][j]);
            }
            Collections.sort(col, (a, b) -> Integer.compare(a.value, b.value));
            for(int i = 1; i < m; ++i) {
                Node previous = col.get(i-1);
                Node current = col.get(i);
                if (current.value > previous.value) { // previous is a dependency.
                    current.find().previouses.add(previous);
                } else { // previous is the same as current.
                    current.union(previous);
                }
            }
        }
        // process dependencies.
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                Node root = nodes[i][j].find();
                if (root != nodes[i][j]) {
                    root.previouses.addAll(nodes[i][j].previouses);
                }
            }
        }
        // result.
        int[][] result = new int[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                result[i][j] = nodes[i][j].find().getRank();
            }
        }
        return result;
    }

    static class Node {

        Node parent = this;
        int size = 1;

        int value;
        int rank = -1;
        Set<Node> previouses = new HashSet<>();

        Node(int value) {
            this.value = value;
        }

        Node find() {
            if (parent != this) {
                parent = parent.find();
            }
            return parent;
        }

        void union(Node that) {
            Node x = this.find();
            Node y = that.find();
            if (x == y) {
                return;
            }
            if (x.size < y.size) {
                Node tmp = x;
                x = y;
                y = tmp;
            }
            y.parent = x;
            x.size += y.size;
        }

        int getRank() {
            if (rank == -1) {
                if (previouses.isEmpty()) { // no dependency from row/col.
                    rank = 1;
                } else {
                    int max = 0;
                    for(Node node : previouses) {
                        max = Math.max(max, node.find().getRank());
                    }
                    rank = max + 1; // set the rank as the max of the dependency's rank + 1.
                }
            }
            return rank;
        }
    }
}
