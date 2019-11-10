import java.util.HashMap;
import java.util.HashSet;

public class S1252CellsOddValuesMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] column = new int[m];

        for (int[] indice : indices) {
            int r = indice[0], c = indice[1];
            row[r]++;
            column[c]++;
        }
        int res = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if ((row[r]+column[c])%2 == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
