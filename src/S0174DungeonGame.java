import java.util.LinkedList;
import java.util.Queue;

public class S0174DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) {
            return 1;
        }
        int M = dungeon.length, N = dungeon[0].length;
        int[][] dp = new int[M][N];
        dp[M-1][N-1] = dungeon[M-1][N-1] < 0 ? 1-dungeon[M-1][N-1] : 1;
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{M-1, N-1});
        while (!bfs.isEmpty()) {
            int[] p = bfs.remove();
            int v = dp[p[0]][p[1]];
            if (p[0] > 0) {
                int r = p[0]-1;
                int c = p[1];
                int hp = dungeon[r][c] > v ? 1 : v - dungeon[r][c];
                if (hp < 1) {
                    hp = 1;
                }
                if (dp[r][c] == 0 || dp[r][c] > hp) {
                    dp[r][c] = hp;
                    bfs.add(new int[]{r, c});
                }
            }
            if (p[1] > 0) {
                int r = p[0];
                int c = p[1]-1;
                int hp = dungeon[r][c] > v ? 1 : v - dungeon[r][c];
                if (hp < 1) {
                    hp = 1;
                }
                if (dp[r][c] == 0 || dp[r][c] > hp) {
                    dp[r][c] = hp;
                    bfs.add(new int[]{r, c});
                }
            }
        }

        return dp[0][0];
    }
}
