import java.util.Comparator;
import java.util.PriorityQueue;

public class S1975MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        long res = 0;
        int min = Integer.MAX_VALUE, neg = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                int v = Math.abs(matrix[r][c]);
                res += v;
                min = Math.min(min, v);
                if (matrix[r][c] < 0) {
                    neg++;
                }
            }
        }
        if (neg % 2 != 0) {
            res -= 2 * min;
        }
        return res;
    }
}
