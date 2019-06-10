public class S0084LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
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
