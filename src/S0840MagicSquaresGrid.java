public class S0840MagicSquaresGrid {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length ==  0 || grid[0].length == 0) {
            return 0;
        }
        int M = grid.length;
        int N = grid[0].length;
        int cnt = 0;
        for (int i = 0; i <= M-3; i++) {
            for (int j = 0; j <= N-3; j++) {
                if (grid[i+1][j+1] != 5) {
                    continue;
                }

                int d1 = grid[i][j];
                if (d1 == 2) {
                    if (grid[i][j+1] == 7 &&
                            grid[i][j+2] == 6 &&
                            grid[i+1][j] == 9 &&
                            grid[i+1][j+2] == 1 &&
                            grid[i+2][j] == 4 &&
                            grid[i+2][j+1] == 3 &&
                            grid[i+2][j+2] == 8) {
                        cnt++;
                    } else if (grid[i][j+1] == 9 &&
                            grid[i][j+2] == 4 &&
                            grid[i+1][j] == 7 &&
                            grid[i+1][j+2] == 3 &&
                            grid[i+2][j] == 6 &&
                            grid[i+2][j+1] == 1 &&
                            grid[i+2][j+2] == 8) {
                        cnt++;
                    }
                } else if (d1 == 4) {
                    assert grid[i+2][j] == 2;
                    if (grid[i][j+1] == 3 &&
                            grid[i][j+2] == 8 &&
                            grid[i+1][j] == 9 &&
                            grid[i+1][j+2] == 1 &&
                            grid[i+2][j] == 2 &&
                            grid[i+2][j+1] == 7 &&
                            grid[i+2][j+2] == 6) {
                        cnt++;
                    } else if (grid[i][j+1] == 9 &&
                            grid[i][j+2] == 2 &&
                            grid[i+1][j] == 3 &&
                            grid[i+1][j+2] == 7 &&
                            grid[i+2][j] == 8 &&
                            grid[i+2][j+1] == 1 &&
                            grid[i+2][j+2] == 6) {
                        cnt++;
                    }
                } else if (d1 == 6) {
                    if (grid[i][j+1] == 1 &&
                            grid[i][j+2] == 8 &&
                            grid[i+1][j] == 7 &&
                            grid[i+1][j+2] == 3 &&
                            grid[i+2][j] == 2 &&
                            grid[i+2][j+1] == 9 &&
                            grid[i+2][j+2] == 4) {
                        cnt++;
                    } else if (grid[i][j+1] == 7 &&
                            grid[i][j+2] == 2 &&
                            grid[i+1][j] == 1 &&
                            grid[i+1][j+2] == 9 &&
                            grid[i+2][j] == 8 &&
                            grid[i+2][j+1] == 3 &&
                            grid[i+2][j+2] == 4) {
                        cnt++;
                    }
                } else if (d1 == 8) {
                    if (grid[i][j+1] == 1 &&
                            grid[i][j+2] == 6 &&
                            grid[i+1][j] == 3 &&
                            grid[i+1][j+2] == 7 &&
                            grid[i+2][j] == 4 &&
                            grid[i+2][j+1] == 9 &&
                            grid[i+2][j+2] == 2) {
                        cnt++;
                    } else if (grid[i][j+1] == 3 &&
                            grid[i][j+2] == 4 &&
                            grid[i+1][j] == 1 &&
                            grid[i+1][j+2] == 9 &&
                            grid[i+2][j] == 6 &&
                            grid[i+2][j+1] == 7 &&
                            grid[i+2][j+2] == 2) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
