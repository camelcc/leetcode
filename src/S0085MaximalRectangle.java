public class S0085MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int R = matrix.length, C = matrix[0].length;

        int res = 0;
        int[][] height = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == '0') {
                    height[r][c] = 0;
                } else {
                    height[r][c] = r == 0 ? 1 : height[r-1][c]+1;
                }
            }
            res = Math.max(res, largestRectangleArea(height[r]));
        }

        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] == 0) {
                continue;
            }

            int min = heights[i];
            int left = i;
            int area = 0;
            while (left >= 0) {
                min = Math.min(min, heights[left]);
                area = Math.max(area, min*(i-left+1));
                left--;
            }
            res = Math.max(res, area);
        }
        return res;
    }
}
