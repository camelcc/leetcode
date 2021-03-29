import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S1610MaximumNumberVisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int[] origin = new int[]{location.get(0), location.get(1)};
        List<Double> angles = new ArrayList<>();
        int base = 0;
        for (List<Integer> point : points) {
            int[] p = new int[]{point.get(0), point.get(1)};
            if (origin[0] == p[0] && origin[1] == p[1]) {
                base++;
                continue;
            }
            angles.add(getAngle(origin, p));
        }
        if (angles.isEmpty()) {
            return base;
        }
        Collections.sort(angles);
        double e = angles.get(angles.size()-1) + angle;
        List<Double> data = new ArrayList<>(angles);
        for (int i = 0; i < angles.size(); i++) {
            double a = angles.get(i);
            if (a+360 <= e) {
                data.add(a+360);
            } else {
                break;
            }
        }
        int start = 0, end = 0;
        int res = 0;
        while (start < angles.size()) {
            double as = angles.get(start);
            double ae = as + angle;
            while (end < data.size() && data.get(end) <= ae+0.00000001) {
                end++;
            }
            res = Math.max(res, end-start);
            start++;
        }
        return res + base;
    }

    private double getAngle(int[] origin, int[] point) {
        int x = point[0]-origin[0];
        int y = point[1]-origin[1];
        if (x == 0) {
            return y > 0 ? 90 : 270;
        }
        double angle = Math.atan(1.0*y/x);
        if (x < 0) {
            angle += Math.PI;
        }
        if (angle < 0) {
            angle += 2*Math.PI;
        }
        return angle * 180 / Math.PI;
    }
}
