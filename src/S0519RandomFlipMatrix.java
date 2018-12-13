import java.util.HashMap;
import java.util.Random;

public class S0519RandomFlipMatrix {
    public static class Solution {
        private HashMap<Integer, Integer> ones;
        private int r, c;
        private int total;
        private Random random;

        public Solution(int n_rows, int n_cols) {
            r = n_rows;
            c = n_cols;
            ones = new HashMap<>();
            total = r*c;
            random = new Random();
        }

        public int[] flip() {
            int pos = random.nextInt(total--);
            int p = ones.getOrDefault(pos, pos);
            ones.put(pos, ones.getOrDefault(total, total));
            return new int[]{p/c, p%c};
        }

        public void reset() {
            ones.clear();
            total = r*c;
            random = new Random();
        }
    }
}
