import java.util.ArrayList;
import java.util.List;

public class S0130SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length <= 2) {
            return;
        }
        if (board[0].length <= 2) {
            return;
        }
        int M = board.length;
        int N = board[0].length;

        // search border
        List<Integer> queue = new ArrayList<>();
        // top, bottom
        for (int i = 0; i < N; i++) {
            if (board[0][i] == 'O') {
                queue.add(i);
            }
            if (board[M-1][i] == 'O') {
                queue.add((M-1)*N+i);
            }
        }
        // left, right
        for (int i = 1; i < M-1; i++) {
            if (board[i][0] == 'O') {
                queue.add(i*N);
            }
            if (board[i][N-1] == 'O') {
                queue.add(i*N+N-1);
            }
        }

        List<Integer> connected = new ArrayList<>(queue);
        while (!queue.isEmpty()) {
            int p = queue.remove(0);
            // left
            if (p%N > 0 && board[p/N][p%N - 1] == 'O') {
                if (!connected.contains(p-1)) {
                    connected.add(p-1);
                    queue.add(p-1);
                }
            }
            // top
            if (p/N > 0 && board[p/N-1][p%N] == 'O') {
                if (!connected.contains(p-N)) {
                    connected.add(p-N);
                    queue.add(p-N);
                }
            }
            // right
            if (p%N < N-1 && board[p/N][p%N+1] == 'O') {
                if (!connected.contains(p+1)) {
                    connected.add(p+1);
                    queue.add(p+1);
                }
            }
            // bottom
            if (p/N < M-1 && board[p/N + 1][p%N] == 'O') {
                if (!connected.contains(p+N)) {
                    connected.add(p+N);
                    queue.add(p+N);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'O') {
                    if (!connected.contains(i*N+j)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
}
