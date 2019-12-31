import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class S1301NumberPathsMaxScore {
    public int[] pathsWithMaxScore(List<String> board) {
        int N = board.size();
        int LEFT = 0x1, UPLEFT = 0x2, UP = 0x4, FULL = 0x7;

        char[][] b = new char[N][N];
        for (int r = 0; r < N; r++) {
            String s = board.get(r);
            for (int c = 0; c < N; c++) {
                b[r][c] = s.charAt(c);
            }
        }

        int[][] max = new int[N][N];
        LinkedList<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{N-1, N-1});
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            int r = t[0], c = t[1];
            for (int[] dir : new int[][]{{-1, 0}, {-1, -1}, {0, -1}}) {
                int dr = r + dir[0], dc = c + dir[1];
                if (dr < 0 || dc < 0 || b[dr][dc] == 'X') {
                    continue;
                }

                int v = (dr == 0 && dc == 0) ? 0 : b[dr][dc]-'0';
                if (max[dr][dc] < max[r][c]+v) {
                    max[dr][dc] = max[r][c]+v;
                    bfs.offer(new int[]{dr, dc});
                }
            }
        }

        int[][] paths = new int[N][N];
        for (int r = 0; r < N; r++) {
            Arrays.fill(paths[r], -1);
        }
        paths[N-1][N-1] = 1;
        return new int[]{max[0][0], paths(b, max, paths, 0, 0)};
    }

    private int paths(char[][] board, int[][] max, int[][] paths, int r, int c) {
        if (paths[r][c] != -1) {
            return paths[r][c];
        }
        if (board[r][c] == 'X') {
            paths[r][c] = 0;
            return 0;
        }

        int MOD = (int)Math.pow(10, 9)+7;
        int N = max.length;
        int res = 0, m = 0;
        for (int[] dir : new int[][]{{0, 1}, {1, 1}, {1, 0}}) {
            int dr = r + dir[0], dc = c + dir[1];
            if (dr >= N || dc >= N || max[dr][dc] < m || board[dr][dc] == 'X') {
                continue;
            }

            if (max[dr][dc] == m) {
                long t = ((long)res + paths(board, max, paths, dr, dc))%MOD;
                res = (int)t;
            } else { // max[dr][dc] > m
                m = max[dr][dc];
                res = paths(board, max, paths, dr, dc);
            }
        }

        paths[r][c] = res;
        return res;
    }
}
