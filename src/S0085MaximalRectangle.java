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

    private int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] leftPos = new int[heights.length];
        leftPos[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int v = heights[i];
            int l = i-1;
            while (l >= 0 && heights[l] >= v) {
                l = leftPos[l];
            }
            leftPos[i] = l;
        }

        int[] rightPos = new int[heights.length];
        rightPos[heights.length-1] = heights.length;
        for (int i = heights.length-2; i >= 0; i--) {
            int v = heights[i];
            int r = i+1;
            while (r < heights.length && heights[r] >= v) {
                r = rightPos[r];
            }
            rightPos[i] = r;
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i]*(rightPos[i]-leftPos[i]-1));
        }
        return res;
    }
}
