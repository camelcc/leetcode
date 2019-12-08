import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class S1284MinimumNumberFlipsConvertBinaryMatrixZeroMatrix {
    public int minFlips(int[][] mat) {
        int M = mat.length, N = mat[0].length;

        HashSet<Integer> visited = new HashSet<>();
        LinkedList<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[]{toInt(mat, M, N), 0});
        while (!bfs.isEmpty()) {
            int[] t = bfs.poll();
            if (t[0] == 0) {
                return t[1];
            }
            visited.add(t[0]);

            int[][] m = toMat(M, N, t[0]);
            for (int r = 0; r < M; r++) {
                for (int c = 0; c < N; c++) {
                    int[][] f = flip(m, M, N, r, c);
                    int fv = toInt(f, M, N);
                    if (visited.contains(fv)) {
                        continue;
                    }

                    bfs.offer(new int[]{fv, t[1]+1});
                }
            }
        }
        return -1;
    }

    private int toInt(int[][] mat, int M, int N) {
        int v = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                v = (v<<1)|mat[r][c];
            }
        }
        return v;
    }

    private int[][] toMat(int M, int N, int v) {
        int[][] mat = new int[M][N];
        for (int r = M-1; r >= 0; r--) {
            for (int c = N-1; c >= 0; c--) {
                int d = v%2;
                mat[r][c] = d;
                v = v>>1;
            }
        }
        return mat;
    }

    private int[][] flip(int[][] mat, int M, int N, int r, int c) {
        int[][] clone = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                clone[i][j] = mat[i][j];
            }
        }
        for (int[] p : new int[][]{{-1, 0}, {0, -1}, {0, 0}, {0, 1}, {1, 0}}) {
            int fr = r+p[0], fc = c+p[1];
            if (fr >= 0 && fr < M && fc >= 0 && fc < N) {
                if (clone[fr][fc] == 0) {
                    clone[fr][fc] = 1;
                } else {
                    clone[fr][fc] = 0;
                }
            }
        }
        return clone;
    }
}
