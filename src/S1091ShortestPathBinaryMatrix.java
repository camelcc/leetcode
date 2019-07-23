import java.util.LinkedList;
import java.util.Queue;

public class S1091ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        int[][] DIRECTIONS = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        if (grid[0][0] == 1 || grid[N-1][N-1] == 1) {
            return -1;
        }
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            if (t[0] == N-1 && t[1] == N-1) {
                return t[2];
            }
            for (int[] d : DIRECTIONS) {
                int r = t[0]+d[0], c = t[1]+d[1];
                if (r < 0 || r >= N || c < 0 || c >= N || grid[r][c] == 1 || visited[r][c]) {
                    continue;
                }
                visited[r][c] = true;
                bfs.offer(new int[]{r, c, t[2]+1});
            }
        }
        return -1;
    }
}
