import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class S2250CountNumberRectanglesContainingEachPoint {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<Integer>[] rects = new List[101];
        for (int i = 0; i < rects.length; i++) {
            rects[i] = new ArrayList<>();
        }
        for (int[] rect : rectangles) {
            rects[rect[1]].add(rect[0]);
        }
        for (int i = 0; i < rects.length; i++) {
            Collections.sort(rects[i]);
        }
        int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int cnt = 0;
            for (int h = points[i][1]; h <= 100; h++) {
                int p = Collections.binarySearch(rects[h], points[i][0]);
                if (p < 0) {
                    p = -(p+1);
                }
                cnt += rects[h].size()-p;
            }

            res[i] = cnt;
        }
        return res;
    }
}
