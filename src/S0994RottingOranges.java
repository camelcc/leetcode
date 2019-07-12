import java.util.HashSet;

public class S0994RottingOranges {
    public int orangesRotting(int[][] grid) {
        HashSet<Integer> fresh = new HashSet<>();
        HashSet<Integer> rotten = new HashSet<>();
        int M = grid.length, N = grid[0].length;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    fresh.add(r*N+c);
                } else if (grid[r][c] == 2) {
                    rotten.add(r*N+c);
                }
            }
        }
        int res = 0;
        int[][] DIRECTIONS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while (!rotten.isEmpty() && !fresh.isEmpty()) {
            res++;
            HashSet<Integer> next = new HashSet<>();
            for (int n : rotten) {
                int r = n/N, c = n%N;
                for (int[] d : DIRECTIONS) {
                    int dr = r+d[0], dc = c+d[1];
                    if (dr < 0 || dr >= M || dc < 0 || dc >= N || grid[dr][dc] != 1) {
                        continue;
                    }
                    next.add(dr*N+dc);
                    fresh.remove(dr*N+dc);
                    grid[dr][dc] = 2;
                }
            }
            rotten = next;
        }
        if (!fresh.isEmpty()) {
            return -1;
        }
        return res;
    }
}
