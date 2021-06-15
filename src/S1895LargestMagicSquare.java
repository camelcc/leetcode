public class S1895LargestMagicSquare {
    public int largestMagicSquare(int[][] grid) {
        int res = 1;
        int M = grid.length, N = grid[0].length;
        int[][] row = new int[M][N];
        int[][] column = new int[M][N];
        int[][] topleft = new int[M][N];
        int[][] topright = new int[M][N];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                row[r][c] = c == 0 ? grid[r][c] : grid[r][c]+row[r][c-1];
                column[r][c] = r == 0 ? grid[r][c] : grid[r][c] + column[r-1][c];
                topleft[r][c] = (r == 0 || c == 0) ? grid[r][c] : grid[r][c]+topleft[r-1][c-1];
                topright[r][c] = (r == 0 || c == N-1) ? grid[r][c] : grid[r][c]+topright[r-1][c+1];

                for (int len = Math.min(r, c)+1; len > res; len--) {
                    int l = c-len+1;
                    int t = r-len+1;
                    int sum = topleft[r][c]- ((l == 0 || t == 0) ? 0 : topleft[t-1][l-1]);
                    if (sum != topright[r][l]-((t == 0 || c == N-1) ? 0 : topright[t-1][c+1])) {
                        continue;
                    }
                    boolean match = true;
                    for (int sr = t; sr <= r; sr++) {
                        if (sum != row[sr][c]-(l == 0 ? 0 : row[sr][l-1])) {
                            match = false;
                            break;
                        }
                    }
                    if (!match) {
                        continue;
                    }
                    for (int sc = l; sc <= c; sc++) {
                        if (sum != column[r][sc]-(t == 0 ? 0 : column[t-1][sc])) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        res = len;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
