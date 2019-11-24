import java.util.HashSet;

public class S1267CountServersCommunicate {
    public int countServers(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[] serverRow = new int[M];
        int[] serverColumn = new int[N];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    serverRow[r]++;
                    serverColumn[c]++;
                }
            }
        }

        int res = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    if (serverRow[r] > 1 || serverColumn[c] > 1) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
