import java.util.Arrays;
import java.util.HashMap;

public class S2304MinimumPathCostGrid {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int M = grid.length, N = grid[0].length;
        int[] min = new int[M*N];
        Arrays.fill(min, Integer.MAX_VALUE);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            res = Math.min(res, min(grid, moveCost, 0, i, min));
        }
        return res;
    }

    private int min(int[][] grid, int[][] moveCost, int r, int c, int[] min) {
        int M = grid.length, N = grid[0].length;
        int v = grid[r][c];
        if (min[v] != Integer.MAX_VALUE) {
            return min[v];
        }
        if (r == M-1) {
            min[v] = v;
            return v;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int tr = v + moveCost[v][i] + min(grid, moveCost, r+1, i, min);
            res = Math.min(res, tr);
        }
        min[v] = res;
        return res;
    }
}
