public class S0289GameofLife {
    public void gameOfLife(int[][] board) {
        int M = board.length;
        int N = board[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (isLive(board, i * N + j)) {
                    board[i][j] |= 0x2;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private boolean isLive(int[][] board, int pos) {
        int M = board.length;
        int N = board[0].length;

        int m = pos / N;
        int n = pos % N;

        int live = board[m][n] & 0x1;

        int lifes = 0;
        if (m > 0 && n > 0) {
            if ((board[m-1][n-1] & 0x1) == 1) {
                lifes++;
            }
        }
        if (m > 0) {
            if ((board[m-1][n] & 0x1) == 1) {
                lifes++;
            }
        }
        if (m > 0 && n < N-1) {
            if ((board[m-1][n+1] & 0x1) == 1) {
                lifes++;
            }
        }
        if (n < N-1) {
            if ((board[m][n+1] & 0x1) == 1) {
                lifes++;
            }
        }
        if (m < M-1 && n < N-1) {
            if ((board[m+1][n+1] & 0x1) == 1) {
                lifes++;
            }
        }
        if (m < M-1) {
            if ((board[m+1][n] & 0x1) == 1) {
                lifes++;
            }
        }
        if (m < M-1 && n > 0) {
            if ((board[m+1][n-1] & 0x1) == 1) {
                lifes++;
            }
        }
        if (n > 0) {
            if ((board[m][n-1] & 0x1) == 1) {
                lifes++;
            }
        }

        if (live == 0) {
            return lifes == 3;
        } else {
            return lifes == 2 || lifes == 3;
        }
    }
}
