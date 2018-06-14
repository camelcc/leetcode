public class S0463IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int column = grid[0].length;
        if (column == 0) {
            return 0;
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == 0) {
                    continue;
                }
                // left
                if (c == 0 || grid[r][c-1] == 0) {
                    perimeter++;
                }
                // top
                if (r == 0 || grid[r-1][c] == 0) {
                    perimeter++;
                }
                // right
                if (c == column-1 || grid[r][c+1] == 0) {
                    perimeter++;
                }
                // bottom
                if (r == row-1 || grid[r+1][c] == 0) {
                    perimeter++;
                }
            }
        }
        return perimeter;
    }
}
