import java.util.ArrayList;
import java.util.List;

public class S0529Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0) {
            return board;
        }
        final int M = board.length;
        final int N = board[0].length;

        int r = click[0];
        int c = click[1];
        if (board[r][c] != 'M' && board[r][c] != 'E') {
            throw new IllegalArgumentException("invalid input");
        }
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }

        // board[r][c] = 'E'
        List<Integer> empty = new ArrayList<>();
        empty.add(r*N+c);
        while (!empty.isEmpty()) {
            int p = empty.remove(0);
            int pr = p/N;
            int pc = p%N;
            List<Integer> adj = new ArrayList<>();
            int mines = mines(board, pr, pc, adj);
            if (mines == 0) {
                board[pr][pc] = 'B';
                for (Integer a : adj) {
                    if (board[a/N][a%N] == 'E' && !empty.contains(a)) {
                        empty.add(a);
                    }
                }
            } else {
                board[pr][pc] = (char)('0' + mines);
            }
        }

        return board;
    }

    private int mines(char[][] board, int r, int c, List<Integer> adj) {
        int count = 0;
        int M = board.length;
        int N = board[0].length;
        if (c > 0) {
            if (board[r][c-1] == 'M') {
                count++;
            }
            adj.add(r*N+c-1);
        }
        if (r > 0 && c > 0) {
            if  (board[r-1][c-1] == 'M') {
                count++;
            }
            adj.add((r-1)*N+c-1);
        }
        if (r > 0) {
            if (board[r-1][c] == 'M') {
                count++;
            }
            adj.add((r-1)*N+c);
        }
        if (r > 0  && c < N-1) {
            if (board[r-1][c+1] == 'M') {
                count++;
            }
            adj.add((r-1)*N+c+1);
        }
        if (c < N-1) {
            if (board[r][c+1] == 'M') {
                count++;
            }
            adj.add(r*N+c+1);
        }
        if (r < M-1 && c < N-1) {
            if (board[r+1][c+1] == 'M') {
                count++;
            }
            adj.add((r+1)*N+c+1);
        }
        if (r < M-1) {
            if (board[r+1][c] == 'M') {
                count++;
            }
            adj.add((r+1)*N+c);
        }
        if (r < M-1 && c > 0) {
            if (board[r+1][c-1] == 'M') {
                count++;
            }
            adj.add((r+1)*N+c-1);
        }
        return count;
    }
}
