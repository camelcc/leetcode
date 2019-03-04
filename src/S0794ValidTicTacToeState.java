public class S0794ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        char[] all = board[0].concat(board[1]).concat(board[2]).toCharArray();
        assert all.length == 9;

        int cntx = 0, cnto = 0;
        for (char c : all) {
            if (c == 'X') {
                cntx++;
            } else if (c == 'O') {
                cnto++;
            }
        }
        if (cntx < cnto) {
            return false;
        } else if (cntx > cnto) {
            if (cntx-cnto > 1) {
                return false;
            }
        }
        // cntx >= cnto
        char winner = ' ';
        if (all[0] != ' ' && all[0] == all[1] && all[0] == all[2]) {
            winner = all[0];
        }
        if (all[3] != ' ' && all[3] == all[4] && all[3] == all[5]) {
            if (winner != ' ' && winner != all[3]) {
                return false;
            }
            winner = all[3];
        }
        if (all[6] != ' ' && all[6] == all[7] && all[6] == all[8]) {
            if (winner != ' ' && winner != all[6]) {
                return false;
            }
            winner = all[6];
        }
        if (all[0] != ' ' && all[0] == all[3] && all[0] == all[6]) {
            if (winner != ' ' && winner != all[0]) {
                return false;
            }
            winner = all[0];
        }
        if (all[1] != ' ' && all[1] == all[4] && all[1] == all[7]) {
            if (winner != ' ' && winner != all[1]) {
                return false;
            }
            winner = all[1];
        }
        if (all[2] != ' ' && all[2] == all[5] && all[2] == all[8]) {
            if (winner != ' ' && winner != all[2]) {
                return false;
            }
            winner = all[2];
        }
        if (all[0] != ' ' && all[0] == all[4] && all[0] == all[8]) {
            if (winner != ' ' && winner != all[0]) {
                return false;
            }
            winner = all[0];
        }
        if (all[2] != ' ' && all[2] == all[4] && all[2] == all[6]) {
            if (winner != ' ' && winner != all[2]) {
                return false;
            }
            winner = all[2];
        }

        if (cntx > cnto) {
            // x win or no winner
            if (winner == 'O') {
                return false;
            }
        } else { // cntx == cnto
            // o win or no winner
            if (winner == 'X') {
                return false;
            }
        }
        return true;
    }
}
