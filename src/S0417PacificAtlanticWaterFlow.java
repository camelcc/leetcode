import java.util.ArrayList;
import java.util.List;

public class S0417PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int M = matrix.length;
        int N = matrix[0].length;
        List<Integer> pacifics = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            pacifics.add(i);
        }
        for (int i = 1; i < M; i++) {
            pacifics.add(i*N);
        }
        List<Integer> pacificFlows = flows(matrix, pacifics);

        List<Integer> altlantic = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            altlantic.add((M-1)*N + i);
        }
        for (int i = 0; i < M-1; i++) {
            altlantic.add(i*N + N - 1);
        }
        List<Integer> altlanticFlows = flows(matrix, altlantic);

        for (int p : pacificFlows) {
            if (altlanticFlows.contains(p)) {
                int[] n = new int[2];
                n[0] = p/N;
                n[1] = p%N;
                res.add(n);
            }
        }
        return res;
    }

    private List<Integer> flows(int[][] matrix, List<Integer> points) {
        List<Integer> res = new ArrayList<>(points);

        int M = matrix.length;
        int N = matrix[0].length;

        while (!points.isEmpty()) {
            int node = points.remove(0);
            int row = node/N;
            int column = node%N;
            int val = matrix[row][column];

            // left
            if (column > 0 && matrix[row][column-1] >= val) {
                int l = row*N + column - 1;
                if (!res.contains(l)) {
                    res.add(l);
                    points.add(l);
                }
            }
            // up
            if (row > 0 && matrix[row-1][column] >= val) {
                int u = (row-1)*N + column;
                if (!res.contains(u)) {
                    res.add(u);
                    points.add(u);
                }
            }
            // right
            if (column < N-1 && matrix[row][column+1] >= val) {
                int r = row * N + column + 1;
                if (!res.contains(r)) {
                    res.add(r);
                    points.add(r);
                }
            }
            // down
            if (row < M-1 && matrix[row+1][column] >= val) {
                int d = (row + 1) * N + column;
                if (!res.contains(d)) {
                    res.add(d);
                    points.add(d);
                }
            }
        }
        return res;
    }
}
