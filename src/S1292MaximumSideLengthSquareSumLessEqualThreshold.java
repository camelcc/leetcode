public class S1292MaximumSideLengthSquareSumLessEqualThreshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int M = mat.length, N = mat[0].length;
        int[][] sum = new int[M][N];
        int res = 0;
        for (int r = 0; r < M; r++) {
            int preSum = 0;
            for (int c = 0; c < N; c++) {
                preSum += mat[r][c];
                sum[r][c] = (r == 0 ? 0 : sum[r-1][c])+preSum;
                int len = 1;
                while (r-len+1 >= 0 && c-len+1 >= 0) {
                    long area = sum[r][c]; // D
                    if (r-len >= 0 && c-len >= 0) {
                        area += sum[r-len][c-len];
                    }
                    if (c-len >= 0) {
                        area -= sum[r][c-len];
                    }
                    if (r-len >= 0) {
                        area -= sum[r-len][c];
                    }
                    if (area <= threshold) {
                        res = Math.max(res, len);
                    }
                    len++;
                }
            }
        }
        return res;
    }
}
