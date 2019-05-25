import java.util.Arrays;

public class S0741CherryPickup {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][][] dp = new int[N+1][N+1][N+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[1][1][1] = grid[0][0];
        for(int x1 = 1; x1 <= N; x1++){
            for(int y1 = 1; y1 <= N; y1++){
                for(int x2 = 1; x2 <= N; x2++){
                    int y2 = x1 + y1 - x2;
                    if(dp[x1][y1][x2] > 0 || y2 < 1 || y2 > N || grid[x1 - 1][y1 - 1] == -1 || grid[x2 - 1][y2 - 1] == -1){
                        continue;
                        // have already detected || out of boundary || cannot access
                    }
                    int cur = Math.max(Math.max(dp[x1 - 1][y1][x2], dp[x1 - 1][y1][x2 - 1]), Math.max(dp[x1][y1 - 1][x2], dp[x1][y1 - 1][x2 - 1]));
                    if(cur < 0){
                        continue;
                    }
                    dp[x1][y1][x2] = cur + grid[x1 - 1][y1 - 1];
                    if(x1 != x2){
                        dp[x1][y1][x2] += grid[x2 - 1][y2 - 1];
                    }
                }
            }
        }
        return Math.max(0, dp[N][N][N]);
    }
}
