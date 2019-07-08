import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S0963MinimumAreaRectangleII {
    public double minAreaFreeRect(int[][] p) {
        Map<String, List<int[]>> map = new HashMap<>();

        for(int i = 0; i < p.length; i++) {
            for(int j = i + 1; j < p.length; j++) {
                double x = (p[i][0] + p[j][0]) / 2.0;
                double y = (p[i][1] + p[j][1]) / 2.0;
                String key = x + ","+ y + "," + getDist(p, i, j);
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(new int[]{i, j});
            }
        }


        double res = Double.MAX_VALUE;
        for(List<int[]> l : map.values()) {
            for(int i = 0; i < l.size(); i++) {
                for(int j = i + 1; j < l.size(); j++) {
                    res = Math.min(res, getArea(p, l.get(i), l.get(j)));
                }
            }
        }

        return res == Double.MAX_VALUE ? 0 : res;
    }

    int getDist(int[][] p, int i, int j) {
        return (p[i][0]-p[j][0])*(p[i][0]-p[j][0]) + (p[i][1]-p[j][1])*(p[i][1]-p[j][1]);
    }

    double getArea(int[][] p, int[] a, int[] b) {
        int dis1 = getDist(p, a[0], b[0]);
        int dis2 = getDist(p, a[0], b[1]);
        return Math.sqrt(dis1) * Math.sqrt(dis2);
    }
}
