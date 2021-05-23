import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToIntFunction;

public class S1738FindKthLargestXORCoordinateValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int M = matrix.length, N = matrix[0].length;
        int[][] value = new int[M][N];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                int v = matrix[r][c];
                if (c > 0) {
                    v = v ^ value[r][c-1];
                }
                if (r > 0) {
                    v = v ^ value[r-1][c];
                }
                if (c > 0 && r > 0) {
                    v = v ^ value[r-1][c-1];
                }
                value[r][c] = v;
            }
        }
        for (int r = 0; r < M; r++) {
            Arrays.sort(value[r]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((ToIntFunction<int[]>) o -> value[o[0]][o[1]]).reversed());
        for (int r = 0; r < M; r++) {
            pq.offer(new int[]{r, N-1});
        }
        int c = 1;
        while (c != k) {
            int[] t = pq.poll();
            c++;
            if (t[1] > 0) {
                pq.offer(new int[]{t[0], t[1]-1});
            }
        }
        int[] r = pq.poll();
        return value[r[0]][r[1]];
    }
}
