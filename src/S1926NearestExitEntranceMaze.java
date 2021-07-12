import java.util.LinkedList;

public class S1926NearestExitEntranceMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int M = maze.length, N = maze[0].length;
        boolean[][] visited = new boolean[M][N];
        int res = 0;
        LinkedList<int[]> bfs = new LinkedList<>();
        bfs.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        while (!bfs.isEmpty()) {
            res++;
            LinkedList<int[]> next = new LinkedList<>();
            for (int[] t : bfs) {
                int r = t[0], c = t[1];
                for (int[] dir : new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}}) {
                    int nr = r+dir[0], nc = c+dir[1];
                    if (nr < 0 || nr >= M || nc < 0 || nc >= N || maze[nr][nc] == '+' || visited[nr][nc]) {
                        continue;
                    }
                    if (nr == 0 || nr == M-1 || nc == 0 || nc == N-1) {
                        return res;
                    }
                    visited[nr][nc] = true;
                    next.offer(new int[]{nr, nc});
                }
            }
            bfs = next;
        }
        return -1;
    }
}
