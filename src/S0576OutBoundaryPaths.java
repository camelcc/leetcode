import java.util.Arrays;
import java.util.HashMap;

public class S0576OutBoundaryPaths {
    private HashMap<Integer, int[][]> paths;

    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) {
            return 0;
        }
        paths = new HashMap<>();
        return path(m, n, N, i, j);
    }

    private int path(int m, int n, int N, int i, int j) {
        int[][] p;
        if (paths.containsKey(N)) {
            p = paths.get(N);
        } else {
            p = new int[m][n];
            for (int t = 0; t < m; t++) {
                Arrays.fill(p[t], -1);
            }
            paths.put(N, p);
        }
        if (p[i][j] != -1) {
            return p[i][j];
        }
        long res = 0;


        if (N == 1) {
            if (i == 0) {
                res++;
            }
            if (i == m-1) {
                res++;
            }
            if (j == 0) {
                res++;
            }
            if (j == n-1) {
                res++;
            }
        } else { // N > 1
            // left
            if (j == 0) {
                res++;
            } else {
                res += path(m, n, N-1, i, j-1);
            }
            // up
            if (i == 0) {
                res++;
            } else {
                res += path(m, n, N-1, i-1, j);
            }
            // right
            if (j == n-1) {
                res++;
            } else {
                res += path(m, n, N-1, i, j+1);
            }
            // down
            if (i == m-1) {
                res++;
            } else {
                res += path(m, n, N-1, i+1, j);
            }
        }

        res = res % ((long)Math.pow(10, 9) + 7);

        p[i][j] = (int)res;
        return (int)res;
    }
}
