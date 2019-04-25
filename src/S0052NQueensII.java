import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0052NQueensII {
    public int totalNQueens(int n) {
        int res = 0;
        for (int i = 0; i < n * n; i++) {
            List<Integer> queens = new ArrayList<>();
            queens.add(i);
            res += dfs(queens, n);
        }
        return res;
    }

    private int dfs(List<Integer> queens, int n) {
        int res = 0;
        if (queens.size() == n) {
            return 1;
        }

        char[][] board = new char[n][n];
        for (char[] b : board) {
            Arrays.fill(b, '.');
        }
        for (int queen : queens) {
            board[queen/n][queen%n] = 'Q';
        }

        int last = queens.get(queens.size()-1);
        for (int next = last+1; next < n*n; next++) {
            int[] p = new int[] {next/n, next%n};
            if (!valid(board, p, n)) {
                continue;
            }
            queens.add(next);
            res += dfs(queens, n);
            queens.remove((Integer)next);
        }

        return res;
    }

    private boolean valid(char[][] board, int[] pos, int n) {
        for (int r = 0; r < n; r++) {
            if (board[r][pos[1]] == 'Q') {
                return false;
            }
        }
        for (int c = 0; c < n; c++) {
            if (board[pos[0]][c] == 'Q') {
                return false;
            }
        }
        int r = pos[0], c = pos[1];
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }
        r = pos[0];
        c = pos[1];
        while (r < n && c < n) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r++;
            c++;
        }
        r = pos[0];
        c = pos[1];
        while (r >= 0 && c < n) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c++;
        }
        r = pos[0];
        c = pos[1];
        while (r < n && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r++;
            c--;
        }
        return true;
    }
}
