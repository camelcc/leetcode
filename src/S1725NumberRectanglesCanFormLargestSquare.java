public class S1725NumberRectanglesCanFormLargestSquare {
    public int countGoodRectangles(int[][] rectangles) {
        int res = 0, len = 0;
        for (int[] rec : rectangles) {
            int l = Math.min(rec[0], rec[1]);
            if (l == len) {
                res++;
            } else if (l > len) {
                len = l;
                res = 1;
            }
        }
        return res;
    }
}
