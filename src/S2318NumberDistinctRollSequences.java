import java.util.Arrays;

public class S2318NumberDistinctRollSequences {
    public int distinctSequences(int n) {
        boolean[][] graph = new boolean[7][7];
        Arrays.fill(graph[0], true);
        graph[0][0] = false;
        Arrays.fill(graph[1], true);
        graph[1][0] = false;
        graph[1][1] = false;
        graph[2][1] = true;
        graph[2][3] = true;
        graph[2][5] = true;
        graph[3][1] = true;
        graph[3][2] = true;
        graph[3][4] = true;
        graph[3][5] = true;
        graph[4][1] = true;
        graph[4][3] = true;
        graph[4][5] = true;
        graph[5][1] = true;
        graph[5][2] = true;
        graph[5][3] = true;
        graph[5][4] = true;
        graph[5][6] = true;
        graph[6][1] = true;
        graph[6][5] = true;

        int MOD = 1_000_000_007;
        long[][] cnt = new long[7][7];
        cnt[0][0] = 1;
        for (int i = 0; i < n; i++) {
            long[][] next = new long[7][7];
            for (int r = 0; r < 7; r++) {
                for (int c = 0; c < 7; c++) {
                    if (cnt[r][c] == 0) {
                        continue;
                    }
                    for (int nc = 0; nc < 7; nc++) {
                        if (graph[c][nc] && r != nc) {
                            next[c][nc] = (next[c][nc] + cnt[r][c])%MOD;
                        }
                    }
                }
            }
            cnt = next;
        }

        long res = 0;
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 7; c++) {
                res = (res + cnt[r][c])%MOD;
            }
        }
        return (int)res;
    }
}
