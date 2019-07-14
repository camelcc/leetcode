public class S0999AvailableCapturesRook {
    public int numRookCaptures(char[][] board) {
        int M = board.length, N = board[0].length;
        int[][] DIRECTIONS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int res = 0;

        int[] rook = rook(board);
        assert rook != null;
        for (int[] d : DIRECTIONS) {
            int r = rook[0]+d[0], c = rook[1]+d[1];
            while (r >= 0 && r < M && c >= 0 && c < N) {
                if (board[r][c] == '.') {
                    r += d[0];
                    c += d[1];
                } else {
                    if (board[r][c] == 'p') {
                        res++;
                    }
                    break;
                }
            }
        }
        return res;
    }

    private int[] rook(char[][] board) {
        int M = board.length, N = board[0].length;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == 'R') {
                    return new int[]{r, c};
                }
            }
        }
        return null;
    }
}
