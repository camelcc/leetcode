public class S1828QueriesNumberPointsInsideCircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cx = queries[i][0], cy = queries[i][1], cr = queries[i][2], cnt = 0;
            for (int[] point : points) {
                int x = point[0], y = point[1];
                if (((x-cx)*(x-cx)+(y-cy)*(y-cy)) <= cr*cr) {
                    cnt++;
                }
            }
            res[i] = cnt;
        }
        return res;
    }
}
