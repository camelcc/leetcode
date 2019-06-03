import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S0850RectangleAreaII {
    private class Segs {
        List<int[]> segs = new ArrayList<>();

        public void add(int start, int end) {
            segs.add(new int[]{start, end});
        }

        public void remove(int start, int end) {
            for (int i = 0; i < segs.size(); i++) {
                int[] seg = segs.get(i);
                if (seg[0] == start && seg[1] == end) {
                    segs.remove(i);
                    return;
                }
            }
        }

        public int range() {
            if (segs.isEmpty()) {
                return 0;
            }

            Collections.sort(segs, (int[] o1, int[] o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0]-o2[0];
                }
                return o2[1]-o1[1];
            });
            int res = 0;
            int start = segs.get(0)[0];
            int end = segs.get(0)[1];
            for (int i = 1; i < segs.size(); i++) {
                int[] seg = segs.get(i);
                if (seg[1] <= end) {
                    continue;
                }

                if (seg[0] <= end) {
                    end = seg[1];
                    continue;
                }

                res += end-start;
                start = seg[0];
                end = seg[1];
            }
            res += end-start;
            return res;
        }
    }

    public int rectangleArea(int[][] rectangles) {
        if (rectangles.length == 0) {
            return 0;
        }

        int xl = rectangles[0][0], xr = rectangles[0][2];

        ArrayList<int[]> segs = new ArrayList<>();
        for (int[] rect : rectangles) {
            if (xl > rect[0]) {
                xl = rect[0];
            }
            if (xr < rect[2]) {
                xr = rect[2];
            }
            segs.add(new int[]{rect[1], rect[0], rect[2], 1});
            segs.add(new int[]{rect[3], rect[0], rect[2], -1});
        }
        Collections.sort(segs, (int[] o1, int[] o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0]-o2[0];
            }
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            if (o1[2] != o2[2]) {
                return o1[2] - o2[2];
            }
            return o1[3]-o2[3];
        });
        Segs range = new Segs();
        long res = 0;
        int currentXRange = 0;
        int currentY = 0;
        for (int[] seg : segs) {
            int y = seg[0];
            int x0 = seg[1];
            int x1 = seg[2];
            res += (long)(y-currentY) * currentXRange;
            currentY = y;
            if (seg[3] == 1) {
                range.add(x0, x1);
            } else if (seg[3] == -1) {
                range.remove(x0, x1);
            }
            currentXRange = range.range();
        }
        return (int)(res%((int)Math.pow(10, 9)+7));
    }
}
