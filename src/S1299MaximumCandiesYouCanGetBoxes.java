import java.util.HashSet;

public class S1299MaximumCandiesYouCanGetBoxes {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] reached = new boolean[n];
        boolean[] visited = new boolean[n];
        HashSet<Integer> ks = new HashSet<>();
        for (int b : initialBoxes) {
            reached[b] = true;
            if (status[b] == 1 || ks.contains(b)) {
                visit(b, reached, visited, ks, status, keys, containedBoxes);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                res += candies[i];
            }
        }
        return res;
    }

    private void visit(int box, boolean[] reached, boolean[] visited, HashSet<Integer> ks, int[] status, int[][] keys, int[][] edges) {
        if (visited[box]) {
            return;
        }
        visited[box] = true;
        for (int k : keys[box]) {
            ks.add(k);
        }
        for (int adj : edges[box]) {
            reached[adj] = true;
        }
        for (int i = 0; i < reached.length; i++) {
            if (reached[i] && (status[i] == 1 || ks.contains(i))) {
                visit(i, reached, visited, ks, status, keys, edges);
            }
        }
    }
}
