import java.util.Arrays;
import java.util.Comparator;

public class S0835ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;

        int[][] indexs = new int[N*N][3];
        int i = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                indexs[i][0] = r;
                indexs[i][1] = c;
                indexs[i][2] = (r+1)*(c+1);
                i++;
            }
        }
        Arrays.sort(indexs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2]-o1[2];
            }
        });
        int res = 0;
        i = 0;
        while (i < indexs.length && indexs[i][2] > res) {
            res = Math.max(res, overlap(A, B, indexs[i]));
            res = Math.max(res, overlap(B, A, indexs[i]));
            i++;
        }
        return res;
    }

    private int overlap(int[][] A, int[][] B, int[] pos) {
        int N = A.length;

        int res = 0;
        for (int r = 0; r <= pos[0]; r++) {
            for (int c = 0; c <= pos[1]; c++) {
                if (A[N-1-pos[0]+r][N-1-pos[1]+c] == 1 && B[r][c] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
