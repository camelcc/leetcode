import java.util.HashMap;
import java.util.LinkedList;

public class S1992FindAllGroupsFarmland {
    public int[][] findFarmland(int[][] land) {
        HashMap<Integer, int[]> groups = new HashMap<>();
        int g = 1;
        int M = land.length, N = land[0].length;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (land[r][c] == 0) {
                    continue;
                }
                if (land[r][c] == 1) {
                    g++;
                    groups.put(g, new int[]{r, c, r, c});
                    LinkedList<int[]> bfs = new LinkedList<>();
                    bfs.offer(new int[]{r, c});
                    while (!bfs.isEmpty()) {
                        int[] t = bfs.poll();
                        for (int[] dir : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
                            int nr = t[0]+dir[0], nc = t[1] + dir[1];
                            if (nr < 0 || nr >= M || nc < 0 || nc >= N || land[nr][nc] != 1) {
                                continue;
                            }
                            land[nr][nc] = g;
                            bfs.offer(new int[]{nr, nc});
                        }
                    }
                } else {
                    int[] t = groups.get(land[r][c]);
                    if (t[2] < r || t[3] < c) {
                        t[2] = r;
                        t[3] = c;
                    }
                }
            }
        }
        int[][] res = new int[groups.size()][4];
        int i = 0;
        for (int[] v : groups.values()) {
            res[i++] = v;
        }
        return res;
    }
}
