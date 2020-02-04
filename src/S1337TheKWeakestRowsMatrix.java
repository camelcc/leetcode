import java.util.Arrays;

public class S1337TheKWeakestRowsMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int M = mat.length, N = mat[0].length;
        int[][] rows = new int[M][2];
        for (int r = 0; r < M; r++) {
            int s = 0;
            for (int c = 0; c < N && mat[r][c] == 1; c++) {
                s++;
            }
            rows[r] = new int[]{r, s};
        }

        Arrays.sort(rows, (int[] o1, int[] o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            return o1[0]-o2[0];
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = rows[i][0];
        }
        return res;
    }
}
