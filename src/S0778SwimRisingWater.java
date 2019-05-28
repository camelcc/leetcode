import java.util.Comparator;
import java.util.PriorityQueue;

public class S0778SwimRisingWater {
    public int swimInWater(int[][] grid) {
        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int N = grid.length;
        int time = 0;
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<int[]> bfs = new PriorityQueue<>(Comparator.comparingInt((int[] o) -> grid[o[0]][o[1]]));
        bfs.add(new int[]{0, 0});
        while (!bfs.isEmpty()) {
            int[] pos = bfs.poll();
            if (grid[pos[0]][pos[1]] > time) {
                time = grid[pos[0]][pos[1]];
            }
            visited[pos[0]][pos[1]] = true;
            if (pos[0] == N-1 && pos[1] == N-1) {
                return time;
            }
            for (int[] dir : directions) {
                int r = pos[0]+dir[0];
                int c = pos[1]+dir[1];
                if (r < 0 || r >= N || c < 0 || c >= N) {
                    continue;
                }
                if (visited[r][c]) {
                    continue;
                }
                bfs.add(new int[]{r, c});
            }
        }
        return time;
    }
}
