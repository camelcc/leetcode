import java.util.LinkedList;

public class S1263MinimumMovesMoveBoxTheirTargetLocation {
    public int minPushBox(char[][] grid) {
        int N = grid.length, M = grid[0].length;
        int[][][][] dp = new int[N][M][N][M];
        for (int br = 0; br < N; br++) {
            for (int bc = 0; bc < M; bc++) {
                for (int pr = 0; pr < N; pr++) {
                    for (int pc = 0; pc < M; pc++) {
                        dp[br][bc][pr][pc] = -1;
                    }
                }
            }
        }
        LinkedList<int[][]> bfs = new LinkedList<>();
        int[] sb = null, sp = null, target = null;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (grid[r][c] == 'B') {
                    sb = new int[]{r, c};
                } else if (grid[r][c] == 'S') {
                    sp = new int[]{r, c};
                } else if (grid[r][c] == 'T') {
                    target = new int[]{r, c};
                }
            }
        }
        assert sb != null && sp != null && target != null;

        dp[sb[0]][sb[1]][sp[0]][sp[1]] = 0;
        bfs.offer(new int[][]{sb, sp});

        int res = -1;
        while (!bfs.isEmpty()) {
            int[][] t = bfs.poll();
            int[] box = t[0], player = t[1];
            int steps = dp[box[0]][box[1]][player[0]][player[1]];
            if (box[0] == target[0] && box[1] == target[1]) {
                if (res == -1) {
                    res = steps;
                } else {
                    res = Math.min(res, steps);
                }
                continue;
            }

            for (int[] dir : new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}}) {
                int npr = player[0]+dir[0];
                int npc = player[1]+dir[1];
                if (npr < 0 || npr >= N || npc < 0 || npc >= M || grid[npr][npc] == '#') {
                    continue;
                }

                if (npr == box[0] && npc == box[1]) {
                    int nbr = box[0]+dir[0];
                    int nbc = box[1]+dir[1];
                    if (nbr < 0 || nbr >= N || nbc < 0 || nbc >= M || grid[nbr][nbc] == '#') {
                        continue;
                    }
                    if (dp[nbr][nbc][npr][npc] >= 0 && dp[nbr][nbc][npr][npc] <= steps+1) {
                        continue;
                    }
                    dp[nbr][nbc][npr][npc] = steps+1;
                    bfs.offer(new int[][]{new int[]{nbr, nbc}, new int[]{npr, npc}});
                } else {
                    if (dp[box[0]][box[1]][npr][npc] >= 0 && dp[box[0]][box[1]][npr][npc] <= steps) {
                        continue;
                    }
                    dp[box[0]][box[1]][npr][npc] = steps;
                    bfs.offer(new int[][]{new int[]{box[0], box[1]}, new int[]{npr, npc}});
                }
            }
        }
        return res;
    }
}
