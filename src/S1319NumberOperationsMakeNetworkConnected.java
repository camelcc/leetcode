import java.util.HashSet;

public class S1319NumberOperationsMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1) {
            return -1;
        }

        int[] conn = new int[n];
        for (int i = 0; i < n; i++) {
            conn[i] = i;
        }

        for (int[] c : connections) {
            int a = root(conn, c[0]);
            int b = root(conn, c[1]);
            conn[Math.max(a, b)] = conn[Math.min(a, b)];
        }

        HashSet<Integer> groups = new HashSet<>();
        for (int i = 0; i < n; i++) {
            groups.add(root(conn, i));
        }
        return groups.size()-1;
    }

    private int root(int[] conn, int i) {
        while (conn[i] != i) {
            i = conn[i];
        }
        return i;
    }
}
