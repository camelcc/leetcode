import java.util.LinkedList;

public class S1391CheckThereValidPathGrid {
    public boolean hasValidPath(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int LEFT = 0x1, TOP = 0x2, RIGHT = 0x4, BOTTOM = 0x8;

        int[][] visited = new int[M][N];
        LinkedList<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{0, 0, LEFT});
        bfs.offer(new int[]{0, 0, RIGHT});
        bfs.offer(new int[]{0, 0, TOP});
        bfs.offer(new int[]{0, 0, BOTTOM});
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            if (t[0] < 0 || t[0] >= M || t[1] < 0 || t[1] >= N) {
                continue;
            }
            int r = t[0], c = t[1], d = t[2], v = grid[r][c];
            if ((visited[r][c]&d) > 0) {
                continue;
            }

            switch (v) {
                case 1:
                    if (d == LEFT) {
                        visited[r][c] |= d;
                        bfs.offer(new int[]{r, c+1, LEFT});
                    } else if (d == RIGHT) {
                        visited[r][c] |= d;
                        bfs.offer(new int[]{r, c-1, RIGHT});
                    }
                    break;
                case 2:
                    if (d == TOP) {
                        visited[r][c] |= d;
                        bfs.offer(new int[]{r+1, c, TOP});
                    } else if (d == BOTTOM) {
                        visited[r][c] |= d;
                        bfs.offer(new int[]{r-1, c, BOTTOM});
                    }
                    break;
                case 3:
                    if (d == LEFT) {
                        visited[r][c] |= d;
                        bfs.offer(new int[]{r+1, c, TOP});
                    } else if (d == BOTTOM) {
                        visited[r][c] |= d;
                        bfs.offer(new int[]{r, c-1, RIGHT});
                    }
                    break;
                case 4:
                    if (d == RIGHT) {
                        visited[r][c] |= d;
                        bfs.offer(new int[]{r+1, c, TOP});
                    } else if (d == BOTTOM) {
                        visited[r][c] |= d;
                        bfs.offer(new int[]{r, c+1, LEFT});
                    }
                    break;
                case 5:
                    if (d == LEFT) {
                        visited[r][c] |= d;
                        bfs.offer(new int[]{r-1, c, BOTTOM});
                    } else if (d == TOP) {
                        visited[r][c] |= d;
                        bfs.offer(new int[]{r, c-1, RIGHT});
                    }
                    break;
                case 6:
                    if (d == TOP) {
                        visited[r][c] |= d;
                        bfs.offer(new int[]{r, c+1, LEFT});
                    } else if (d == RIGHT) {
                        visited[r][c] |= d;
                        bfs.offer(new int[]{r-1, c, BOTTOM});
                    }
                    break;
                default:
                    break;
            }
        }
        return visited[M-1][N-1] > 0;
    }
}
