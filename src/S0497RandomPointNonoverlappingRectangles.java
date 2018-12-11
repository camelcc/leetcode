import java.util.Arrays;
import java.util.Random;

public class S0497RandomPointNonoverlappingRectangles {
    class Solution {
        private int[][] rects;
        private int[] count;
        private int total;
        private Random rand;

        public Solution(int[][] rects) {
            this.rects = rects;
            count = new int[rects.length];
            total = 0;
            for (int i = 0; i < rects.length; i++) {
                int[] rect = rects[i];
                int x_s = rect[0];
                int y_s = rect[1];
                int x_e = rect[2];
                int y_e = rect[3];
                int cnt = (x_e - x_s + 1) * (y_e - y_s + 1);
                total += cnt;
                count[i] = total;
            }
            rand = new Random();
        }

        public int[] pick() {
            int p = rand.nextInt(total);
            int pos = Arrays.binarySearch(count, p);
            if (pos >= 0) {
                pos = pos + 1;
            } else {
                pos = -(pos+1);
            }
            p = p - (pos > 0 ? count[pos-1] : 0);
            int[] rect = rects[pos];
            int x_s = rect[0];
            int y_s = rect[1];
            int x_e = rect[2];
            int w = x_e - x_s + 1;

            return new int[]{x_s + p%w, y_s + p/w};
        }
    }
}
