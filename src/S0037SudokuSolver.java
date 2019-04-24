import java.util.Arrays;

public class S0037SudokuSolver {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    private boolean dfs(char[][] board) {
        int r = 0, c = 0;
        boolean empty = false;
        for (r = 0; r < 9; r++) {
            for (c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    empty = true;
                    break;
                }
            }
            if (empty) {
                break;
            }
        }
        if (!empty) {
            return true;
        }
        int R = 3*(r/3), C = 3*(c/3);
        boolean[] candidates = new boolean[10];
        Arrays.fill(candidates, true);
        candidates[0] = false;
        for (int i = 0; i < 9; i++) {
            if (board[i][c] != '.') {
                candidates[board[i][c]-'0'] = false;
            }
            if (board[r][i] != '.') {
                candidates[board[r][i]-'0'] = false;
            }
            if (board[R+i/3][C+i%3] != '.') {
                candidates[board[R+i/3][C+i%3]-'0'] = false;
            }
        }
        for (int i = 0; i < candidates.length; i++) {
            if (!candidates[i]) {
                continue;
            }

            board[r][c] = (char)(i+'0');
            if (dfs(board)) {
                return true;
            }
        }
        board[r][c] = '.';
        return false;
    }
}
