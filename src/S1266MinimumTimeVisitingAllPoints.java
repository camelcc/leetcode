public class S1266MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length <= 1) {
            return 0;
        }

        int res = 0;
        int[] prev = points[0];
        int i = 1;
        while (i < points.length) {
            res += min(prev, points[i]);
            prev = points[i];
            i++;
        }
        return res;
    }

    private int min(int[] start, int[] end) {
        int xd = Math.abs(start[0] - end[0]);
        int yd = Math.abs(start[1] - end[1]);
        return Math.max(yd, xd);
    }
}
