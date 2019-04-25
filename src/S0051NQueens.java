import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0051NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n * n; i++) {
            List<int[]> queens = new ArrayList<>();
            queens.add(new int[]{i/n, i%n});
            res.addAll(dfs(queens, n));
        }
        return res;
    }

    private List<List<String>> dfs(List<int[]> queens, int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];
        for (char[] b : board) {
            Arrays.fill(b, '.');
        }
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = 'Q';
        }

        if (queens.size() == n) {
            List<String> r = new ArrayList<>();
            for (char[] b : board) {
                r.add(new String(b));
            }
            res.add(r);
            return res;
        }

        int[] last = queens.get(queens.size()-1);
        for (int next = last[0]*n+last[1]+1; next < n*n; next++) {
            int[] p = new int[] {next/n, next%n};
            if (!valid(board, p, n)) {
                continue;
            }
            queens.add(p);
            res.addAll(dfs(queens, n));
            queens.remove(p);
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
