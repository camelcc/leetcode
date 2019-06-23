import java.util.LinkedList;
import java.util.Queue;

public class S0909SnakesandLadders {
    public int snakesAndLadders(int[][] board) {
        int M = board.length, N = board[0].length;
        int end = M*N;
        boolean[][] visited = new boolean[M][N];
        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{1, 0});
        visited[M-1][0] = true;
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            int pos = t[0];
            int times = t[1];
            if (pos == end) {
                return times;
            }
            if (pos + 6 >= end) {
                return times+1;
            }

            for (int m = 1; m <= 6; m++) {
                int np = pos+m-1;
                int nr = M-1-(np/N);
                int nc = (np/N)%2 == 0 ? np%N : N-1-np%N;
                if (board[nr][nc] != -1) {
                    np = board[nr][nc]-1;
                    nr = M-1-(np/N);
                    nc = (np/N)%2 == 0 ? np%N : N-1-np%N;
                }

                if (!visited[nr][nc]) {
                    bfs.offer(new int[]{np+1, times+1});
                    visited[nr][nc] = true;
                }
            }
        }

        return -1;
    }
}
