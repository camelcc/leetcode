import java.util.Arrays;
import java.util.Random;

public class S0528RandomPickWeight {
    class Solution {
        private int[] s;
        private int sum;
        private Random rand;

        public Solution(int[] w) {
            s = new int[w.length];
            sum = 0;
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                s[i] = sum;
            }
            rand = new Random();
        }

        public int pickIndex() {
            int p = rand.nextInt(sum);
            int pos = Arrays.binarySearch(s, p);
            if (pos >= 0) {
                pos++;
            } else {
                pos = -(pos + 1);
            }
            return pos;
        }
    }
}
