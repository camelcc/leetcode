import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class S1439FindKthSmallestSumMatrixWithSortedRows {
    public int kthSmallest(int[][] mat, int k) {
        int M = mat.length, N = mat[0].length;

        int[] s = new int[M+1];
        for (int r = 0; r < M; r++) {
            s[M] += mat[r][0];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[M]));
        pq.offer(s);
        HashSet<String> visited = new HashSet<>();

        int i = 0, res = 0;
        while (i < k) {
            int[] t = pq.poll();
            String key = key(t, M);
            if (visited.contains(key)) {
                continue;
            }

            i++;
            res = t[M];
            int sum = t[M];
            if (i == k) {
                return sum;
            }
            visited.add(key(t, M));

//            int[] indices = t[1..M]
            for (int r = 0; r < M; r++) {
                int c = t[r];
                if (c+1 >= N) {
                    continue;
                }
                int[] next = Arrays.copyOf(t, t.length);
                next[r]++;
                if (visited.contains(key(next, M))) {
                    continue;
                }

                next[M] = next[M]-mat[r][c]+mat[r][c+1];
                pq.offer(next);
            }
        }
        return res;
    }

    private String key(int[] t, int M) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(t[i]).append(",");
        }
        return sb.toString();
    }
}
