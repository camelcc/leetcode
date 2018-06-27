import java.util.ArrayList;
import java.util.List;

public class S0079WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) {
            return true;
        }
        if (board.length == 0) {
            return false;
        }

        int N = board.length;
        int M = board[0].length;

        char next = word.charAt(0);

        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == next) {
                    queue.add(i*M+j);
                    if (exist(board, queue, i, j, word.substring(1))) {
                        return true;
                    }
                    queue.remove(queue.size()-1);
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, List<Integer> queue, int row, int column, String word) {
        if (word.isEmpty()) {
            return true;
        }
        if (board.length == 0) {
            return false;
        }

        int N = board.length;
        int M = board[0].length;

        char next = word.charAt(0);

        // up
        if (row > 0 && board[row-1][column] == next && !queue.contains(Integer.valueOf((row-1)*M+column))) {
            List<Integer> clone = new ArrayList<>(queue);
            clone.add((row-1)*M+column);
            if (exist(board, clone, row-1, column, word.substring(1))) {
                return true;
            }
        }
        // right
        if (column < M-1 && board[row][column+1] == next && !queue.contains(Integer.valueOf(row*M+column+1))) {
            List<Integer> clone = new ArrayList<>(queue);
            clone.add(row*M+column+1);
            if (exist(board, clone, row, column+1, word.substring(1))) {
                return true;
            }
        }
        // bottom
        if (row < N-1 && board[row+1][column] == next && !queue.contains(Integer.valueOf((row+1)*M+column))) {
            List<Integer> clone = new ArrayList<>(queue);
            clone.add((row+1)*M+column);
            if (exist(board, clone, row+1, column, word.substring(1))) {
                return true;
            }
        }
        // left
        if (column > 0 && board[row][column-1] == next && !queue.contains(Integer.valueOf(row*M+column-1))) {
            List<Integer> clone = new ArrayList<>(queue);
            clone.add(row*M+column-1);
            if (exist(board, clone, row, column-1, word.substring(1))) {
                return true;
            }
        }
        return false;
    }
}
