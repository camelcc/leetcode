public class S0498DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        int M = matrix.length;
        if (M == 0) {
            return new int[0];
        }
        int N = matrix[0].length;
        if (N == 0) {
            return new int[0];
        }
        int[] res = new int[M*N];
        boolean up = true;
        int m = 1, n = -1;
        int i = 0;
        while (i < M*N) {
            if (up) {
                m--;
                n++;
            } else {
                m++;
                n--;
            }
            res[i++] = matrix[m][n];

            if (up) {
                if (m == 0 || n == N-1) {
                    up = false;
                    if (n == N-1) {
                        n++;
                    } else {
                        m = -1;
                        n += 2;
                    }
                }
            } else {
                if (n == 0 || m == M-1) {
                    up = true;
                    if (m == M-1) {
                        m++;
                    } else {
                        n = -1;
                        m += 2;
                    }
                }
            }
        }
        return res;
    }
}
