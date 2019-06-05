import java.util.HashSet;
import java.util.LinkedList;

public class S0864ShortestPathGetAllKeys {
    public int shortestPathAllKeys(String[] grid) {
        int ALL_KEYS = (1<<6)-1;
        int[][] DIRECTIONS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int k = ALL_KEYS;
        int M = grid.length, N = grid[0].length();
        int x = -1, y = -1;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                char t = grid[r].charAt(c);
                if (t == '@') {
                    x = r;
                    y = c;
                } else if (t >= 'A' && t <= 'F') {
                    k = k ^ (1 << (t-'A'));
                }
            }
        }
        LinkedList<int[]> bfs = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        bfs.add(new int[]{x, y, k});
        String state = String.format("%d,%d,%d", x, y, k);
        visited.add(state);
        int steps = 0;
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                int[] t = bfs.poll();
                int r = t[0];
                int c = t[1];
                int keys = t[2];
                if (keys == ALL_KEYS) {
                    return steps;
                }
                for (int[] dir : DIRECTIONS) {
                    int dr = r+dir[0];
                    int dc = c+dir[1];
                    int dk = keys;
                    if (dr < 0 || dr >= M || dc < 0 || dc >= N) {
                        continue;
                    }
                    char ch = grid[dr].charAt(dc);
                    if (ch == '#') {
                        continue;
                    }
                    if (ch >= 'a' && ch <= 'f') {
                        dk = dk | (1 << (ch-'a'));
                    } else if (ch >= 'A' && ch <= 'F') {
                        if ((dk & (1<<(ch-'A'))) == 0) {
                            continue;
                        }
                    }
                    String s = String.format("%d,%d,%d", dr, dc, dk);
                    if (!visited.contains(s)) {
                        bfs.offer(new int[]{dr, dc, dk});
                        visited.add(s);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
