public class S1779FindNearestPointThatHasSameXYCoordinate {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int res = -1, distance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int d = Math.abs(point[0]-x)+Math.abs(point[1]-y);
                if (d < distance) {
                    res = i;
                    distance = d;
                }
            }
        }
        return res;
    }
}
