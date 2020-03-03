import java.util.Arrays;
import java.util.LinkedList;

public class S1368MinimumCostMakeLeastOneValidPathGrid {
    public int minCost(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[][] DIR = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] dp = new int[M][N];
        for (int r = 0; r < M; r++) {
            Arrays.fill(dp[r], -1);
        }
        dp[M-1][N-1] = 0;

        LinkedList<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{M-1, N-1});

        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            int r = t[0], c = t[1], s = dp[r][c];
            for (int[] d : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                int pr = r+d[0], pc = c+d[1];
                if (pr < 0 || pr >= M || pc < 0 || pc >= N) {
                    continue;
                }
                int[] gd = DIR[grid[pr][pc]];
                int tr = pr+gd[0], tc = pc+gd[1];
                int ps = s + ((tr == r && tc == c) ? 0 : 1);
                if (dp[pr][pc] == -1 || dp[pr][pc] > ps) {
                    dp[pr][pc] = ps;
                    bfs.offer(new int[]{pr, pc});
                }
            }
        }
        return dp[0][0];
    }
}
