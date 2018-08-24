public class S0419BattleshipsBoard {
    public int countBattleships(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }

        int M = board.length;
        int N = board[0].length;
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'X') {
                    if ((i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j-1] == '.')) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
