import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class S2013DetectSquares {
    public static class DetectSquares {
        HashMap<Integer, Integer>[] xm;
        HashMap<Integer, Integer>[] ym;

        public DetectSquares() {
            xm = new HashMap[1001];
            ym = new HashMap[1001];
            for (int i = 0; i < 1001; i++) {
                xm[i] = new HashMap<>();
                ym[i] = new HashMap<>();
            }
        }

        public void add(int[] point) {
            int x = point[0], y = point[1];
            xm[x].put(y, xm[x].getOrDefault(y, 0)+1);
            ym[y].put(x, ym[y].getOrDefault(x, 0)+1);
        }

        public int count(int[] point) {
            // [x, y]
            int x = point[0], y = point[1];
            int res = 0;
            for (int xx : ym[y].keySet()) {
                if (xx == x) {
                    continue;
                }
                int len = Math.abs(xx-x);
                // [xx, y]
                int xc = ym[y].get(xx);

                // [xx, y-|x-xx|]
                if (xm[xx].containsKey(y-len)) {
                    int yc = xm[xx].get(y-len);

                    // [x, y-|x-xx|]
                    res += xc * yc * xm[x].getOrDefault(y-len, 0);
                }

                // [xx, y+|x-xx|]
                if (xm[xx].containsKey(y+len)) {
                    int yc = xm[xx].get(y+len);

                    // [x, y+|x-xx|]
                    res += xc * yc * xm[x].getOrDefault(y+len, 0);
                }
            }
            return res;
        }
    }
}
