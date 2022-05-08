import java.util.HashSet;

public class S2267CheckThereValidParenthesesStringPath {
    public boolean hasValidPath(char[][] grid) {
        int M = grid.length, N = grid[0].length;
        HashSet<Integer>[][] visited = new HashSet[M][N];
        return dfs(grid, 0, 0, 0, visited);
    }

    private boolean dfs(char[][] grid, int r, int c, int left, HashSet<Integer>[][] visited) {
        int M = grid.length, N = grid[0].length;
        if (visited[r][c] != null && visited[r][c].contains(left)) {
            return false;
        }
        if (visited[r][c] == null) {
            visited[r][c] = new HashSet<>();
        }
        visited[r][c].add(left);
        if (grid[r][c] == '(') {
            left++;
        } else {
            left--;
        }
        if (left < 0) {
            return false;
        }
        // left >= 0
        if (r == M-1 && c == N-1) {
            return left == 0;
        }
        if (r < M-1 && dfs(grid, r+1, c, left, visited)) { // down
            return true;
        }
        if (c < N-1 && dfs(grid, r, c+1, left, visited)) { // right
            return true;
        }
        return false;
    }
}
