public class S0782TransformChessboard {
    public int movesToChessboard(int[][] board) {
        int N = board.length;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if ((board[0][0]^board[r][0]^board[0][c]^board[r][c]) == 1) {
                    return -1;
                }
            }
        }

        int rowOnes = 0, columnOnes = 0;
        int rowSwap = 0, columnSwap = 0;
        for (int i = 0; i < N; ++i) {
            rowOnes += board[0][i];
            columnOnes += board[i][0];
            if (board[i][0] == i % 2) {
                rowSwap++;
            }
            if (board[0][i] == i % 2) {
                columnSwap++ ;
            }
        }
        if (rowOnes != N / 2 && rowOnes != (N + 1) / 2) {
            return -1;
        }
        if (columnOnes != N / 2 && columnOnes != (N + 1) / 2) {
            return -1;
        }

        if (N%2 == 1) {
            if (columnSwap % 2 == 1) {
                columnSwap = N - columnSwap;
            }
            if (rowSwap % 2 == 1) {
                rowSwap = N - rowSwap;
            }
        } else {
            columnSwap = Math.min(columnSwap, N-columnSwap);
            rowSwap = Math.min(rowSwap, N-rowSwap);
        }
        return (columnSwap+rowSwap)/2;
    }
}
