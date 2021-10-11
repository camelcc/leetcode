import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S2033MinimumOperationsMakeUniValueGrid {
    public int minOperations(int[][] grid, int x) {
        int M = grid.length, N = grid[0].length;
        int mod = grid[0][0]%x;
        List<Integer> data = new ArrayList<>();
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c]%x != mod) {
                    return -1;
                }
                data.add(grid[r][c]);
            }
        }
        Collections.sort(data);
        int median = data.get(data.size()/2);
        int res = 0;
        for (int v : data) {
            res += Math.abs(median-v)/x;
        }
        return res;
    }
}
