import java.util.LinkedList;

public class S5053AsFarfromLandPossible {
    public int maxDistance(int[][] grid) {
        int N = grid.length;
        LinkedList<int[]> bfs = new LinkedList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    bfs.offer(new int[]{r, c});
                }
            }
        }
        while (!bfs.isEmpty()) {
            int[] p = bfs.poll();
            int r = p[0], c = p[1], v = grid[r][c];
            for (int[] pos : new int[][]{{r, c-1}, {r-1, c}, {r, c+1}, {r+1, c}}) {
                int pr = pos[0], pc = pos[1];
                if (pr < 0 || pr >= N || pc < 0 || pc >= N || grid[pr][pc] != 0) {
                    continue;
                }
                grid[pr][pc] = v+1;
                bfs.offer(new int[]{pr, pc});
            }
        }

        int max = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                max = Math.max(max, grid[r][c]);
            }
        }
        return max == 1 ? -1 : max-1;
    }
}
