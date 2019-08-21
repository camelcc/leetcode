import java.util.LinkedList;

public class S0130SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int M = board.length, N = board[0].length;
        boolean[][] free = new boolean[M][N];
        LinkedList<int[]> bfs = new LinkedList<int[]>();
        for (int i = 0; i < N; i++) {
            if (board[0][i] == 'O') {
                free[0][i] = true;
                bfs.offer(new int[]{0, i});
            }
            if (board[M-1][i] == 'O') {
                free[M-1][i] = true;
                bfs.offer(new int[]{M-1, i});
            }
        }
        for (int i = 1; i < M-1; i++) {
            if (board[i][0] == 'O') {
                free[i][0] = true;
                bfs.offer(new int[]{i, 0});
            }
            if (board[i][N-1] == 'O') {
                free[i][N-1] = true;
                bfs.offer(new int[]{i, N-1});
            }
        }
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            for (int[] d : new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}}) {
                int dr = t[0]+d[0], dc = t[1]+d[1];
                if (dr < 0 || dr >= M || dc < 0 || dc >= N || board[dr][dc] == 'X' || free[dr][dc]) {
                    continue;
                }
                free[dr][dc] = true;
                bfs.offer(new int[]{dr, dc});
            }
        }
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (!free[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }
    }
}
