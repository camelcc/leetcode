import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0542_01Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }

        int M = matrix.length, N = matrix[0].length;
        int[][] res = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(res[i], -1);
        }

        List<Integer> dis = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    dis.add(i*N+j);
                }
            }
        }

        while (!dis.isEmpty()) {
            int p = dis.remove(0);
            int r = p/N;
            int c = p%N;
            int d = res[r][c];
            if (c > 0 && (res[r][c-1] == -1 || d+1 < res[r][c-1])) {
                res[r][c-1] = d+1;
                dis.add(r*N+c-1);
            }
            if (r > 0 && (res[r-1][c] == -1 || d+1 < res[r-1][c])) {
                res[r-1][c] = d+1;
                dis.add((r-1)*N+c);
            }
            if (c < N-1 && (res[r][c+1] == -1 || d+1 < res[r][c+1])) {
                res[r][c+1] = d+1;
                dis.add(r*N+c+1);
            }
            if (r < M-1 && (res[r+1][c] == -1 || d+1 < res[r+1][c])) {
                res[r+1][c] = d+1;
                dis.add((r+1)*N+c);
            }
        }

        return res;
    }
}
