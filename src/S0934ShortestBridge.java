import java.util.ArrayList;
import java.util.List;

public class S0934ShortestBridge {
    public int shortestBridge(int[][] A) {
        int M = A.length, N = A[0].length;
        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int[] island = findIsland(A, M, N);
        assert island != null;
        List<int[]> edges = new ArrayList<>();
        paint(A, island[0], island[1], edges);
        int steps = 2;
        while (!edges.isEmpty()) {
            steps++;
            List<int[]> outers = new ArrayList<>();
            for (int[] edge : edges) {
                for (int[] dir : directions) {
                    int r = edge[0]+dir[0];
                    int c = edge[1]+dir[1];
                    if (r < 0 || r >= M || c < 0 || c >= N) {
                        continue;
                    }
                    if (A[r][c] == 1) {
                        return steps-3;
                    }
                    if (A[r][c] == 0) {
                        A[r][c] = steps;
                        outers.add(new int[]{r, c});
                    }
                }
            }
            edges = outers;
        }
        return -1;
    }

    private void paint(int[][] A, int r, int c, List<int[]> island) {
        int M = A.length, N = A[0].length;
        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        if (r < 0 || r >= M || c < 0 || c >= N || A[r][c] == 0 || A[r][c] == 2) {
            return;
        }
        island.add(new int[]{r, c});
        A[r][c] = 2;
        for (int[] dir : directions) {
            paint(A, r+dir[0], c+dir[1], island);
        }
    }

    private int[] findIsland(int[][] A, int M, int N) {
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (A[r][c] != 1) {
                    continue;
                }
                return new int[]{r, c};
            }
        }
        return null;
    }
}
