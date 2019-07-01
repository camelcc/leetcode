import java.util.HashMap;
import java.util.HashSet;

public class S0939MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        int area = Integer.MAX_VALUE;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            map.putIfAbsent(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) {
                    continue;
                }
                if (map.get(points[i][0]).contains(points[j][1]) &&
                        map.get(points[j][0]).contains(points[i][1])) {
                    int t = Math.abs(points[i][0]-points[j][0])*Math.abs(points[i][1]-points[j][1]);
                    area = Math.min(area, t);
                }
            }
        }
        return area == Integer.MAX_VALUE ? 0 : area;
    }
}
