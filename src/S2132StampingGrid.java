// https://leetcode.com/problems/stamping-the-grid/discuss/1675412/JavaC%2B%2BPython-Calulate-the-sub-matrix-sum-twice
public class S2132StampingGrid {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length, n = grid[0].length;
        int[][] A = new int[m + 1][n + 1], B = new int[m + 1][n + 1], good = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                A[i + 1][j + 1] = A[i + 1][j] + A[i][j + 1] - A[i][j] + (1 - grid[i][j]);
                if (i + 1 >= stampHeight && j + 1 >= stampWidth) {
                    int x = i + 1 - stampHeight, y = j + 1 - stampWidth;
                    if (A[i + 1][j + 1] - A[x][j + 1] - A[i + 1][y] + A[x][y] == stampWidth * stampHeight)
                        good[i][j]++;
                }
            }
        }
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                B[i + 1][j + 1] = B[i + 1][j] + B[i][j + 1] - B[i][j] + good[i][j];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int x = Math.min(i + stampHeight, m), y = Math.min(j + stampWidth, n);
                if (grid[i][j] == 0 && B[x][y] - B[i][y] - B[x][j] + B[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
