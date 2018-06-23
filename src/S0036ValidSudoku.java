public class S0036ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // each row
        for (int i = 0; i < 9; i++) {
            int[][] pos = new int[9][2];
            for (int j = 0; j < 9; j++) {
                pos[j][0] = i;
                pos[j][1] = j;
            }
            if (!valid(board, pos)) {
                return false;
            }
        }

        // each column
        for (int i = 0; i < 9; i++) {
            int[][] pos = new int[9][2];
            for (int j = 0; j < 9; j++) {
                pos[j][0] = j;
                pos[j][1] = i;
            }
            if (!valid(board, pos)) {
                return false;
            }
        }

        // each block
        for (int i = 0; i < 9; i++) {
            int[][] pos = new int[9][2];
            int x = 3*(i/3);
            int y = 3*(i%3);
            for (int j = 0; j < 9; j++) {
                pos[j][0] = x + j/3;
                pos[j][1] = y + j%3;
            }
            if (!valid(board, pos)) {
                return false;
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int[][] pos) {
        boolean[] digits = new boolean[9];
        for (int i = 0; i < 9; i++) {
            char c = board[pos[i][0]][pos[i][1]];
            if (c == '.') {
                continue;
            }
            int d = (c - '1');
            if (digits[d]) {
                return false;
            }
            digits[d] = true;
        }
        return true;
    }
}
