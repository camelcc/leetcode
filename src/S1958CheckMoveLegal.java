public class S1958CheckMoveLegal {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        if (board[rMove][cMove] != '.') {
            return false;
        }
        int M = board.length, N = board[0].length;
        char op = 'W';
        if (color == 'W') {
            op = 'B';
        }
        int[][] dir = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
        for (int[] d : dir) {
            int r = rMove+d[0];
            int c = cMove+d[1];
            int cnt = 0;
            while (r >= 0 && r < M && c >= 0 && c < N && board[r][c] == op) {
                cnt++;
                r += d[0];
                c += d[1];
            }
            if (r >= 0 && r < M && c >= 0 && c < N && board[r][c] == color && cnt > 0) {
                return true;
            }
        }
        return false;
    }
}
