import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class S1727LargestSubmatrixWithRearrangements {
    public int largestSubmatrix(int[][] matrix) {
        int res = 0;
        int M = matrix.length, N = matrix[0].length;
        int[][] cnt = new int[M][N];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                cnt[r][c] = matrix[r][c] == 0 ? 0 : (r == 0 ? matrix[r][c] : cnt[r-1][c]+1);
            }
        }
        for (int r = 0; r < M; r++) {
            Arrays.sort(cnt[r]);
            for (int c = N-1; c >= 0 && cnt[r][c] > 0; c--) {
                res = Math.max(res, cnt[r][c]*(N-c));
            }
        }
        return res;
    }
}
