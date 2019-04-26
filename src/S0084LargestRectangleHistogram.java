public class S0084LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
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
