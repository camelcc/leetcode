public class S1476SubrectangleQueries {
    class SubrectangleQueries {
        int[][] rect;

        public SubrectangleQueries(int[][] rectangle) {
            rect = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int r = row1; r <= row2; r++) {
                for (int c = col1; c <= col2; c++) {
                    rect[r][c] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return rect[row][col];
        }
    }
}
