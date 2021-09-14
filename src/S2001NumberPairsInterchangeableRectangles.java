import java.util.Arrays;
import java.util.Comparator;

public class S2001NumberPairsInterchangeableRectangles {
    public long interchangeableRectangles(int[][] rectangles) {
        Arrays.sort(rectangles, Comparator.comparingDouble(o -> 1.0*o[0]/o[1]));
        long res = 0;
        int w = rectangles[0][0], h = rectangles[0][1], i = 1;
        long cnt = 1;
        while (i < rectangles.length) {
            if (w*rectangles[i][1] == h*rectangles[i][0]) {
                cnt++;
            } else {
                res += cnt*(cnt-1)/2;
                w = rectangles[i][0];
                h = rectangles[i][1];
                cnt = 1;
            }
            i++;
        }
        res += cnt*(cnt-1)/2;
        return res;
    }
}
