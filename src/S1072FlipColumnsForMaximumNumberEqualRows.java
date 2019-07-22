import java.util.Arrays;

public class S1072FlipColumnsForMaximumNumberEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[] flip = new int[N];
        int res = 0;
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                flip[c] = 1 - matrix[r][c];
            }

            int cnt = 0;
            for(int k = 0; k < M; k++) {
                if(Arrays.equals(matrix[k], matrix[r]) || Arrays.equals(matrix[k], flip)) {
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
