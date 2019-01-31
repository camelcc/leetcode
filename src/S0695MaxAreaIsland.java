import java.util.ArrayList;
import java.util.List;

public class S0695MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length, N = grid[0].length;
        boolean[][] visited = new boolean[M][N];
        int res = 0;

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c] && grid[r][c] == 1) {
                    res = Math.max(res, area(visited, grid, r, c));
                }
            }
        }
        return res;
    }

    private int area(boolean[][] visited, int[][] grid, int r, int c) {
        assert grid[r][c] == 1;
        int res = 0;

        int M = grid.length, N = grid[0].length;
        List<Integer> bfs = new ArrayList<>();
        bfs.add(r*N+c);
        while (!bfs.isEmpty()) {
            int t = bfs.remove(0);
            int tr = t/N, tc = t%N;
            if (visited[tr][tc]) {
                continue;
            }
            res++;
            visited[tr][tc] = true;

            if (tc > 0 && grid[tr][tc-1] == 1 && !visited[tr][tc-1]) {
                bfs.add(tr*N+tc-1);
            }
            if (tr > 0 && grid[tr-1][tc] == 1 && !visited[tr-1][tc]) {
                bfs.add((tr-1)*N+tc);
            }
            if (tc < N-1 && grid[tr][tc+1] == 1 && !visited[tr][tc+1]) {
                bfs.add(tr*N+tc+1);
            }
            if (tr < M-1 && grid[tr+1][tc] == 1 && !visited[tr+1][tc]) {
                bfs.add((tr+1)*N+tc);
            }
        }
        return res;
    }
}
