import java.util.LinkedList;
import java.util.List;

public class S1559DetectCycles2DGrid {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (visited[r][c]) {
                    continue;
                }
                if (dfs(grid, r, c, new boolean[m][n], -1, -1)) {
                    return true;
                }
                bfs(grid, r, c, visited);
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, int r, int c, boolean[][] visited, int pr, int pc) {
        visited[r][c] = true;
        for (int[] d : new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}}) {
            int nr = r + d[0], nc = c + d[1];
            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] != grid[r][c]) {
                continue;
            }
            if (nr == pr && nc == pc) {
                continue;
            }
            if (visited[nr][nc]) {
                return true;
            }
            if (dfs(grid, nr, nc, visited, r, c)) {
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }

    private void bfs(char[][] grid, int r, int c, boolean[][] visited) {
        int M = grid.length, N = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            visited[t[0]][t[1]] = true;
            for (int[] d : new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}}) {
                int nr = t[0]+d[0], nc = t[1]+d[1];
                if (nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc] || grid[nr][nc] != grid[r][c]) {
                    continue;
                }
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
