public class S1240TilingRectangleFewestSquares {
    private int res = 0;

    public int tilingRectangle(int n, int m) {
        int min = Math.min(n, m), max = Math.max(n, m);
        res = brute(min, max);
        boolean[][] tiles = new boolean[min][max];
        dfs(tiles, 0, 0);
        return res;
    }

    private void dfs(boolean[][] tiles, int r, int cnt) {
        if (cnt >= res) {
            return;
        }
        int M = tiles.length, N = tiles[0].length;
        if (r >= M) {
            res = Math.min(res, cnt);
            return;
        }

        int c = 0;
        while (c < N && tiles[r][c]) {
            c++;
        }
        if (c >= N) {
            dfs(tiles, r+1, cnt);
            return;
        }

        // r < M, c < N
        for (int edge = N-c; edge >= 1; edge--) {
            // check edge validation
            if (r+edge > M) {
                continue;
            }

            boolean valid = true;
            for (int i = c; i < c+edge; i++) {
                if (tiles[r][i]) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                continue;
            }

            // fill square with edge length
            for (int fr = r; fr < r+edge; fr++) {
                for (int fc = c; fc < c+edge; fc++) {
                    tiles[fr][fc] = true;
                }
            }
            dfs(tiles, r, cnt+1);
            for (int fr = r; fr < r+edge; fr++) {
                for (int fc = c; fc < c+edge; fc++) {
                    tiles[fr][fc] = false;
                }
            }
        }
    }

    private int brute(int min, int max) {
        if (min == max) {
            return 1;
        }
        if (min == 1) {
            return max;
        }
        int remain = max-min;
        return 1 + brute(Math.min(min, remain), Math.max(min, remain));
    }
}
