import java.util.Arrays;

public class S1275FindWinnerTicTacToeGame {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        for (int r = 0; r < 3; r++) {
            Arrays.fill(board[r], ' ');
        }
        boolean playerA = true;
        for (int[] move : moves) {
            int r = move[0], c = move[1];
            board[r][c] = playerA ? 'X' : 'O';
            playerA = !playerA;
        }
        String w = win(board);
        if (w != null) {
            return w;
        }

        if (moves.length == 9) {
            return "Draw";
        } else {
            return "Pending";
        }
    }

    private String win(char[][] board) {
        if (board[0][0] != ' ' && board[0][0] == board[0][1] && board[0][0] == board[0][2]) {
            return board[0][0] == 'X' ? "A" : "B";
        }
        if (board[1][0] != ' ' && board[1][0] == board[1][1] && board[1][0] == board[1][2]) {
            return board[1][0] == 'X' ? "A" : "B";
        }
        if (board[2][0] != ' ' && board[2][0] == board[2][1] && board[2][0] == board[2][2]) {
            return board[2][0] == 'X' ? "A" : "B";
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][0] && board[0][0] == board[2][0]) {
            return board[0][0] == 'X' ? "A" : "B";
        }
        if (board[0][1] != ' ' && board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
            return board[0][1] == 'X' ? "A" : "B";
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][2] && board[0][2] == board[2][2]) {
            return board[0][2] == 'X' ? "A" : "B";
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return board[0][0] == 'X' ? "A" : "B";
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return board[0][2] == 'X' ? "A" : "B";
        }
        return null;
    }
}
