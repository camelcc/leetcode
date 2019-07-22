import java.util.HashMap;

public class S1074NumberSubmatricesThatSumTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int M = matrix.length, N = matrix[0].length;
        for (int r = 0; r < M; r++) {
            for (int c = 1; c < N; c++) {
                matrix[r][c] = matrix[r][c-1]+matrix[r][c];
            }
        }
        int res = 0;
        for (int cstart = 0; cstart < N; cstart++) {
            for (int cend = cstart; cend < N; cend++) {
                HashMap<Integer, Integer> cnt = new HashMap<>();
                cnt.put(0, 1);
                int cur = 0;
                for (int r = 0; r < M; r++) {
                    cur += matrix[r][cend] - (cstart > 0 ? matrix[r][cstart - 1] : 0);
                    res += cnt.getOrDefault(cur - target, 0);
                    cnt.put(cur, cnt.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}
