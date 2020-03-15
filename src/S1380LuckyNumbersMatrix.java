import java.util.ArrayList;
import java.util.List;

public class S1380LuckyNumbersMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[] min = new int[M];
        for (int r = 0; r < M; r++) {
            int m = Integer.MAX_VALUE;
            for (int c = 0; c < N; c++) {
                m = Math.min(m, matrix[r][c]);
            }
            min[r] = m;
        }
        List<Integer> res = new ArrayList<>();
        for (int c = 0; c < N; c++) {
            List<Integer> max = new ArrayList<>();
            int m = Integer.MIN_VALUE;
            for (int r = 0; r < M; r++) {
                int v = matrix[r][c];
                if (v > m) {
                    max.clear();
                    m = v;
                    if (v == min[r]) {
                        max.add(v);
                    }
                } else if (v == m) {
                    if (v == min[r]) {
                        max.add(v);
                    }
                }
            }
            res.addAll(max);
        }
        return res;
    }
}
