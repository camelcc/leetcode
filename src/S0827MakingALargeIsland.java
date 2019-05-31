import java.util.HashMap;
import java.util.HashSet;

public class S0827MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int res = 0;

        boolean[][] visited = new boolean[M][N];
        HashMap<Integer, Integer> count = new HashMap<>();
        int id = 1;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 0 || visited[r][c]) {
                    continue;
                }
                id++;
                int cnt = mark(grid, visited, r, c, id);
                res = Math.max(res, cnt);
                count.put(id, cnt);
            }
        }


        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] != 0) {
                    continue;
                }
                HashSet<Integer> connect = new HashSet<>();
                for (int[] dir : directions) {
                    int dr = r+dir[0], dc = c+dir[1];
                    if (dr < 0 || dr >= M || dc < 0 || dc >= N || grid[dr][dc] == 0) {
                        continue;
                    }
                    connect.add(grid[dr][dc]);
                }
                int cnt = 1;
                for (int g : connect) {
                    cnt += count.get(g);
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }

    private int mark(int[][] grid, boolean[][] visited, int r, int c, int id) {
        int M = grid.length, N = grid[0].length;
        assert grid[r][c] == 1;
        assert !visited[r][c];
        grid[r][c] = id;
        visited[r][c] = true;
        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int cnt = 1;
        for (int[] dir : directions) {
            int dr = r+dir[0];
            int dc = c+dir[1];
            if (dr < 0 || dr >= M || dc < 0 || dc >= N || grid[dr][dc] == 0 || visited[dr][dc]) {
                continue;
            }
            cnt += mark(grid, visited, dr, dc, id);
        }
        return cnt;
    }




//    private int dfs(int[][] grid) {
//        int M = grid.length, N = grid[0].length;
//        boolean[][] visited = new boolean[M][N];
//        int res = 0;
//        for (int r = 0; r < M; r++) {
//            for (int c = 0; c < N; c++) {
//                if (grid[r][c] == 0 || visited[r][c]) {
//                    continue;
//                }
//                res = Math.max(res, cal(grid, visited, r, c));
//            }
//        }
//        return res;
//    }
//
//    private int cal(int[][] grid, boolean[][] visited, int r, int c) {
//        int M = grid.length, N = grid[0].length;
//        assert grid[r][c] == 1;
//        assert !visited[r][c];
//        visited[r][c] = true;
//        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
//        int res = 0;
//        for (int[] dir : directions) {
//            int dr = r+dir[0], dc = c+dir[1];
//            if (dr < 0 || dr >= M || dc < 0 || dc >= N) {
//                continue;
//            }
//            if (grid[dr][dc] == 1) {
//                assert
//            }
//        }
//    }
}
