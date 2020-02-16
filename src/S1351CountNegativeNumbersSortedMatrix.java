import java.util.Arrays;

public class S1351CountNegativeNumbersSortedMatrix {
    public int countNegatives(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int res = 0;
        for (int r = 0; r < M; r++) {
            if (grid[r][0] < 0) {
                res += N;
                continue;
            }

            if (grid[r][N-1] >= 0) {
                continue;
            }

            int lo = 0, hi = N-1;
            while (lo < hi) {
                int mid = lo+(hi-lo)/2;
                if (grid[r][mid] >= 0) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }
            res += N-lo;
        }
        return res;
    }
}
