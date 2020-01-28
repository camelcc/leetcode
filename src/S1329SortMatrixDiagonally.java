import java.util.*;

public class S1329SortMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int M = mat.length, N = mat[0].length;

        List<int[]> start = new ArrayList<>();
        for (int r = M-1; r >= 0; r--) {
            start.add(new int[]{r, 0});
        }
        for (int c = 1; c < N; c++) {
            start.add(new int[]{0, c});
        }

        int[][] res = new int[M][N];
        for (int[] s : start) {
            List<Integer> arr = new ArrayList<>();
            int r = s[0], c = s[1];
            while (r < M && c < N) {
                arr.add(mat[r][c]);
                r++;
                c++;
            }
            Collections.sort(arr);

            int i = 0;
            r = s[0];
            c = s[1];
            while (r < M && c < N) {
                res[r][c] = arr.get(i);
                r++;
                c++;
                i++;
            }
        }
        return res;
    }
}
