import java.util.Arrays;
import java.util.Comparator;

public class S1637WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int res = 0;
        int c = points[0][0];
        for (int i = 1; i < points.length; i++) {
            res = Math.max(res, points[i][0]-c);
            c = points[i][0];
        }
        return res;
    }
}
