import java.util.ArrayList;
import java.util.List;

public class S1260Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int N = grid.length, M = grid[0].length;
        int down = (k/M)%N;
        int right = k%M;

        int[][] tmp = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                int dr = (r+down)%N;
                if (c+right >= M) {
                    dr = (dr+1)%N;
                }
                int dc = (c+right)%M;
                tmp[dr][dc] = grid[r][c];
            }
        }

        // k < M
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            List<Integer> row = new ArrayList<>();
            for (int c = 0; c < M; c++) {
                row.add(tmp[r][c]);
            }
            res.add(row);
        }

        return res;
    }
}
