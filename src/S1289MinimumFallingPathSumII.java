import java.util.Arrays;
import java.util.PriorityQueue;

public class S1289MinimumFallingPathSumII {
    public int minFallingPathSum(int[][] arr) {
        int M = arr.length, N = arr[0].length;
        int[] current = Arrays.copyOf(arr[0], N);
        PriorityQueue<Integer> cpq = new PriorityQueue<>();
        for (int c : current) {
            cpq.offer(c);
        }

        for (int r = 1; r < M; r++) {
            int[] next = new int[N];
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int c = 0; c < N; c++) {
                cpq.remove(current[c]);
                int m = cpq.peek();
                next[c] = arr[r][c]+m;
                pq.offer(next[c]);
                cpq.offer(current[c]);
            }

            current = next;
            cpq = pq;
        }

        return cpq.peek();
    }
}
