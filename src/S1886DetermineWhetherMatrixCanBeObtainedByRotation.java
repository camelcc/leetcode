import java.util.Arrays;

public class S1886DetermineWhetherMatrixCanBeObtainedByRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        int N = mat.length;
        boolean[] same = new boolean[4];
        Arrays.fill(same, true);
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (mat[r][c] != target[r][c]) {
                    same[0] = false;
                }
                if (mat[c][N-1-r] != target[r][c]) {
                    same[1] = false;
                }
                if (mat[N-1-r][N-1-c] != target[r][c]) {
                    same[2] = false;
                }
                if (mat[N-1-c][r] != target[r][c]) {
                    same[3] = false;
                }
            }
        }
        return same[0] || same[1] || same[2] || same[3];
    }
}
